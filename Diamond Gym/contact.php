<?php
session_start();
/** @var mysqli $conn */
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Join Us - Diamond Gym</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<nav>
    <a href="index.php" class="nav-brand">
        <img src="images/Diamond.png" alt="Diamond Gym" class="nav-logo">
        Diamond Gym
    </a>
    <div class="nav-links">
        <a href="index.php">Home</a>
        <a href="nutrition.php">Nutrition</a>
        <a href="workouts.php">Workouts</a>
        <a href="contact.php" class="active">Join Us</a>
        <?php if (isset($_SESSION["member_id"])): ?>
            <a href="profile.php">My Profile</a>
            <a href="logout.php">Logout</a>
        <?php endif; ?>
    </div>
</nav>

<div class="banner fade" id="top">
    <h1>Join <span>Diamond Gym</span></h1>
    <p>Register or sign in to start your fitness journey.</p>
</div>

<div class="container">

    <?php
    include 'db.php';

    if (isset($_SESSION["member_id"])) {
        header("Location: profile.php");
        exit;
    }

    mysqli_query($conn, "ALTER TABLE members ADD COLUMN IF NOT EXISTS password VARCHAR(255) NOT NULL DEFAULT ''");

    $success   = "";
    $error     = "";
    $activeTab = isset($_POST["tab"]) ? $_POST["tab"] : "register";

    // ── REGISTER ──
    if ($_SERVER["REQUEST_METHOD"] === "POST" && isset($_POST["action"]) && $_POST["action"] === "register") {
        $activeTab = "register";
        $name     = trim($_POST["name"]);
        $email    = trim($_POST["email"]);
        $goal     = trim($_POST["goal"]);
        $password = trim($_POST["password"]);
        $confirm  = trim($_POST["confirm_password"]);

        if (empty($name) || empty($email) || empty($password)) {
            $error = "Name, Email, and Password are required.";
        } elseif (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
            $error = "Please enter a valid email address.";
        } elseif (strlen($password) < 6) {
            $error = "Password must be at least 6 characters.";
        } elseif ($password !== $confirm) {
            $error = "Passwords do not match.";
        } else {
            $emailSafe = mysqli_real_escape_string($conn, $email);
            $check = mysqli_query($conn, "SELECT id FROM members WHERE email='$emailSafe'");
            if (mysqli_num_rows($check) > 0) {
                $error = "This email is already registered. Please sign in.";
            } else {
                $nameSafe = mysqli_real_escape_string($conn, $name);
                $goalSafe = mysqli_real_escape_string($conn, $goal);
                $passHash = password_hash($password, PASSWORD_DEFAULT);
                $passSafe = mysqli_real_escape_string($conn, $passHash);
                $sql = "INSERT INTO members (name, email, goal, password) VALUES ('$nameSafe','$emailSafe','$goalSafe','$passSafe')";
                if (mysqli_query($conn, $sql)) {
                    $newId = mysqli_insert_id($conn);
                    $_SESSION["member_id"]    = $newId;
                    $_SESSION["member_name"]  = $name;
                    $_SESSION["member_email"] = $email;
                    $_SESSION["member_goal"]  = $goal;
                    $_SESSION["member_joined"] = date("M j, Y");
                    header("Location: profile.php");
                    exit;
                } else {
                    $error = "Database error: " . mysqli_error($conn);
                }
            }
        }
    }

    // ── SIGN IN ──
    if ($_SERVER["REQUEST_METHOD"] === "POST" && isset($_POST["action"]) && $_POST["action"] === "signin") {
        $activeTab = "signin";
        $email    = trim($_POST["email"]);
        $password = trim($_POST["password"]);

        if (empty($email) || empty($password)) {
            $error = "Email and Password are required.";
        } elseif (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
            $error = "Please enter a valid email address.";
        } else {
            $emailSafe = mysqli_real_escape_string($conn, $email);
            $result2 = mysqli_query($conn, "SELECT * FROM members WHERE email='$emailSafe'");
            if (mysqli_num_rows($result2) === 0) {
                $error = "No account found with that email. Please register first.";
            } else {
                $member = mysqli_fetch_assoc($result2);
                if (password_verify($password, $member["password"])) {
                    $_SESSION["member_id"]    = $member["id"];
                    $_SESSION["member_name"]  = $member["name"];
                    $_SESSION["member_email"] = $member["email"];
                    $_SESSION["member_goal"]  = $member["goal"];
                    $_SESSION["member_joined"]= date("M j, Y", strtotime($member["joined"]));
                    header("Location: profile.php");
                    exit;
                } else {
                    $error = "Incorrect password. Please try again.";
                }
            }
        }
    }
    ?>

    <?php if ($error): ?>
        <div class="error"><?= $error ?></div>
    <?php endif; ?>

    <!-- AUTH TABS -->
    <div class="auth-tabs">
        <button class="tab-btn <?= $activeTab === 'register' ? 'tab-active' : '' ?>" onclick="switchTab('register')">Register</button>
        <button class="tab-btn <?= $activeTab === 'signin'   ? 'tab-active' : '' ?>" onclick="switchTab('signin')">Sign In</button>
    </div>

    <!-- REGISTER FORM -->
    <div class="form-box auth-panel" id="panel-register" style="display:<?= $activeTab === 'register' ? 'block' : 'none' ?>;">
        <h2 class="form-title">Create Account</h2>
        <form method="POST" action="contact.php">
            <input type="hidden" name="action" value="register">
            <input type="hidden" name="tab"    value="register">

            <label for="reg-name">Full Name *</label>
            <input type="text" id="reg-name" name="name" placeholder="Your name" required>

            <label for="reg-email">Email *</label>
            <input type="email" id="reg-email" name="email" placeholder="your@email.com" required>

            <label for="reg-password">Password * <small>(min 6 chars)</small></label>
            <input type="password" id="reg-password" name="password" placeholder="Create a password" required>

            <label for="reg-confirm">Confirm Password *</label>
            <input type="password" id="reg-confirm" name="confirm_password" placeholder="Repeat your password" required>

            <label for="goal">Fitness Goal</label>
            <select id="goal" name="goal">
                <option value="">-- Select --</option>
                <option value="Muscle Gain">Muscle Gain</option>
                <option value="Fat Loss">Fat Loss</option>
                <option value="Maintenance">Maintenance</option>
                <option value="General Health">General Health</option>
            </select>

            <br>
            <button type="submit" class="btn btn-full">Register</button>
        </form>
        <p class="auth-switch">Already have an account? <a href="#" onclick="switchTab('signin')">Sign In</a></p>
    </div>

    <!-- SIGN IN FORM -->
    <div class="form-box auth-panel" id="panel-signin" style="display:<?= $activeTab === 'signin' ? 'block' : 'none' ?>;">
        <h2 class="form-title">Sign In</h2>
        <form method="POST" action="contact.php">
            <input type="hidden" name="action" value="signin">
            <input type="hidden" name="tab"    value="signin">

            <label for="si-email">Email *</label>
            <input type="email" id="si-email" name="email" placeholder="your@email.com" required>

            <label for="si-password">Password *</label>
            <input type="password" id="si-password" name="password" placeholder="Your password" required>

            <br>
            <button type="submit" class="btn btn-full">Sign In</button>
        </form>
        <p class="auth-switch">Don't have an account? <a href="#" onclick="switchTab('register')">Register</a></p>
    </div>

    <br>
    <a href="#top">↑ Back to top</a> |
    <a href="index.php">Home</a>

</div>

<footer>
    <p>© <?php echo date("Y"); ?> Diamond Gym &mdash; Forged Strength &bull; Unbreakable</p>
    <p><a href="index.php">Home</a> | <a href="nutrition.php">Nutrition</a> | <a href="workouts.php">Workouts</a> | <a href="contact.php">Join Us</a></p>
</footer>

<script>
function switchTab(tab) {
    document.getElementById('panel-register').style.display = tab === 'register' ? 'block' : 'none';
    document.getElementById('panel-signin').style.display   = tab === 'signin'   ? 'block' : 'none';
    document.querySelectorAll('.tab-btn').forEach(function(btn) {
        btn.classList.remove('tab-active');
    });
    document.querySelectorAll('.tab-btn')[tab === 'register' ? 0 : 1].classList.add('tab-active');
}
</script>

</body>
</html>
