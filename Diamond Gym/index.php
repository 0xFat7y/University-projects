<?php session_start(); ?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Diamond Gym - Home</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<nav>
    <a href="index.php" class="nav-brand">
        <img src="images/Diamond.png" alt="Diamond Gym" class="nav-logo">
        Diamond Gym
    </a>
    <div class="nav-links">
        <a href="index.php" class="active">Home</a>
        <a href="nutrition.php">Nutrition</a>
        <a href="workouts.php">Workouts</a>
        <?php if (isset($_SESSION["member_id"])): ?>
            <a href="profile.php">My Profile</a>
            <a href="logout.php">Logout</a>
        <?php else: ?>
            <a href="contact.php">Join Us</a>
        <?php endif; ?>
    </div>
</nav>

<div class="banner fade" id="top">
    <img src="images/Diamond.png" alt="Diamond Gym Logo" class="banner-logo">
    <h1>Diamond <span>Gym</span></h1>
    <p>Forged Strength &bull; Unbreakable</p>
</div>

<div class="container">

    <div class="date-box">
         Today: <strong id="today"></strong>
    </div>

    <div class="quote-box" id="daily-quote"></div>

    <p>Jump to: <a href="#about">About</a> | <a href="#goals">Goals</a></p>
    <br>

    <div id="about">
        <h2>About Diamond Gym</h2>
        <p class="section-text">
            Welcome to Diamond Gym — your all-in-one resource for gym training and nutrition.
            Whether you want to build muscle, lose fat, or just stay healthy, we have a plan for you.
            Use the menu above to explore our workout plans and nutrition guides.
        </p>
    </div>

    <br>

    <div class="cards" id="goals">
        <div class="card">
            <img src="images/workouts.jpg" alt="Workouts">
            <h3>Workouts</h3>
            <p>Structured training plans for beginners and advanced athletes. Push, pull, legs and more.</p>
            <br><a href="workouts.php" class="btn">View Plans</a>
        </div>
        <div class="card">
            <img src="images/nutrition.jfif" alt="Nutrition">
            <h3>Nutrition</h3>
            <p>Learn about macros, meal plans, and the right foods to fuel your performance.</p>
            <br><a href="nutrition.php" class="btn">Learn More</a>
        </div>
    </div>

    <br>
    <a href="#top">↑ Back to top</a>

</div>

<footer>
    <p>© <?php echo date("Y"); ?> Diamond Gym &mdash; Forged Strength &bull; Unbreakable</p>
    <p><a href="index.php">Home</a> | <a href="nutrition.php">Nutrition</a> | <a href="workouts.php">Workouts</a> | <a href="contact.php">Join Us</a></p>
</footer>

<script src="main.js"></script>
</body>
</html>
