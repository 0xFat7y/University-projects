<?php
session_start();
if (!isset($_SESSION["member_id"])) {
    header("Location: contact.php");
    exit;
}

$name   = $_SESSION["member_name"];
$email  = $_SESSION["member_email"];
$goal   = $_SESSION["member_goal"] ?: "Not set";
$joined = $_SESSION["member_joined"];

$goalData = [
    "Muscle Gain"    => ["icon" => "💪", "color" => "#333", "desc" => "Build size & strength"],
    "Fat Loss"       => ["icon" => "🔥", "color" => "#555", "desc" => "Burn fat & get lean"],
    "Maintenance"    => ["icon" => "⚖️",  "color" => "#3a7bd5", "desc" => "Maintain your physique"],
    "General Health" => ["icon" => "❤️",  "color" => "#27ae60", "desc" => "Stay fit & healthy"],
];
$gd       = isset($goalData[$goal]) ? $goalData[$goal] : ["icon" => "🎯", "color" => "#888", "desc" => "Custom goal"];
$goalIcon = $gd["icon"];
$goalDesc = $gd["desc"];

$initials = "";
foreach (explode(" ", trim($name)) as $p) { $initials .= strtoupper($p[0]); }
$initials = substr($initials, 0, 2);

$tips = [
    "Muscle Gain"    => ["Eat in a caloric surplus (~300–500 kcal)", "Hit 1.6–2.2g protein per kg bodyweight", "Follow a progressive overload program", "Sleep 7–9 hours for muscle recovery"],
    "Fat Loss"       => ["Eat in a caloric deficit (~300–500 kcal)", "Keep protein high to preserve muscle", "Mix strength training with cardio", "Track your food intake consistently"],
    "Maintenance"    => ["Match calories to your TDEE", "Stay consistent with your training", "Focus on long-term habit building", "Include both strength and cardio"],
    "General Health" => ["Aim for 150 min moderate activity/week", "Eat plenty of whole foods & vegetables", "Stay hydrated — 2–3L of water daily", "Prioritize sleep and stress management"],
];
$memberTips = isset($tips[$goal]) ? $tips[$goal] : ["Set a clear fitness goal to get started", "Explore our workout and nutrition guides"];
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My Profile - Diamond Gym</title>
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
        <a href="profile.php" class="active">My Profile</a>
        <a href="logout.php">Logout</a>
    </div>
</nav>

<div class="banner fade" id="top">
    <h1>My <span>Profile</span></h1>
    <p>Your personal fitness dashboard</p>
</div>

<div class="container">

    <!-- TOP PROFILE CARD -->
    <div class="pro-card">
        <div class="pro-left">
            <div class="pro-avatar"><?= htmlspecialchars($initials) ?></div>
            <div class="pro-identity">
                <h2 class="pro-name"><?= htmlspecialchars($name) ?></h2>
                <p class="pro-email"> <?= htmlspecialchars($email) ?></p>
                <span class="pro-badge">Diamond Gym Member</span>
            </div>
        </div>
        <div class="pro-right">
            <a href="logout.php" class="btn btn-outline">Logout</a>
        </div>
    </div>

    <br>

    <!-- STATS ROW -->
    <div class="pro-stats">
        <div class="pro-stat-box">
            <span class="pro-stat-icon"><?= $goalIcon ?></span>
            <span class="pro-stat-label">Current Goal</span>
            <span class="pro-stat-value"><?= htmlspecialchars($goal) ?></span>
            <span class="pro-stat-sub"><?= $goalDesc ?></span>
        </div>
        <div class="pro-stat-box">
            <span class="pro-stat-icon">📅</span>
            <span class="pro-stat-label">Member Since</span>
            <span class="pro-stat-value"><?= htmlspecialchars($joined) ?></span>
            <span class="pro-stat-sub">Welcome to Diamond Gym</span>
        </div>
        <div class="pro-stat-box">
            <span class="pro-stat-icon">⚡</span>
            <span class="pro-stat-label">Status</span>
            <span class="pro-stat-value" style="color:#27ae60;">Active</span>
            <span class="pro-stat-sub">Account in good standing</span>
        </div>
    </div>

    <br>

    <!-- TIPS + QUICK LINKS -->
    <div class="pro-bottom">

        <div class="pro-tips-box">
            <h2>Tips for <?= htmlspecialchars($goal) ?></h2>
            <ul class="pro-tips-list">
                <?php foreach ($memberTips as $tip): ?>
                    <li><?= htmlspecialchars($tip) ?></li>
                <?php endforeach; ?>
            </ul>
        </div>

        <div class="pro-links-box">
            <h2>Quick Access</h2>
            <a href="workouts.php" class="pro-link-btn">
                <span class="pro-link-icon"></span>
                <span class="pro-link-text">
                    <strong>Workouts</strong>
                    <small>View training plans</small>
                </span>
            </a>
            <a href="nutrition.php" class="pro-link-btn">
                <span class="pro-link-icon"></span>
                <span class="pro-link-text">
                    <strong>Nutrition</strong>
                    <small>Meal plans & macros</small>
                </span>
            </a>
            <a href="index.php" class="pro-link-btn">
                <span class="pro-link-icon"></span>
                <span class="pro-link-text">
                    <strong>Home</strong>
                    <small>Back to main page</small>
                </span>
            </a>
        </div>

    </div>

</div>

<footer>
    <p>© <?php echo date("Y"); ?> Diamond Gym &mdash; Forged Strength &bull; Unbreakable</p>
    <p><a href="index.php">Home</a> | <a href="nutrition.php">Nutrition</a> | <a href="workouts.php">Workouts</a> | <a href="contact.php">Join Us</a></p>
</footer>

</body>
</html>
