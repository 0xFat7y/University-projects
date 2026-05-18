<?php session_start(); ?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Workouts - Diamond Gym</title>
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
        <a href="workouts.php" class="active">Workouts</a>
        <?php if (isset($_SESSION["member_id"])): ?>
            <a href="profile.php">My Profile</a>
            <a href="logout.php">Logout</a>
        <?php else: ?>
            <a href="contact.php">Join Us</a>
        <?php endif; ?>
    </div>
</nav>

<div class="banner fade" id="top">
    <h1>Workout <span>Plans</span></h1>
    <p>Train smart. Get results.</p>
</div>

<div class="container">

    <p>Jump to: <a href="#beginner">Beginner</a> | <a href="#intermediate">Intermediate</a> | <a href="#cardio">Cardio</a></p>
    <br>

    <div id="beginner">
        <h2>Beginner Plan — 3 Days/Week</h2>
        <br>
        <div class="cards">
            <div class="card">
                <h3>Day 1 — Push</h3>
                <p>
                    Push-ups — 3×12<br>
                    Dumbbell Bench Press — 3×10<br>
                    Shoulder Press — 3×10<br>
                    Lateral Raises — 3×12<br>
                    Tricep Dips — 3×12
                </p>
            </div>
            <div class="card">
                <h3>Day 2 — Pull</h3>
                <p>
                    Pull-ups / Lat Pulldown — 3×8<br>
                    Dumbbell Rows — 3×10<br>
                    Seated Row — 3×10<br>
                    Bicep Curls — 3×12<br>
                    Hammer Curls — 3×12
                </p>
            </div>
            <div class="card">
                <h3>Day 3 — Legs</h3>
                <p>
                    Squats — 3×10<br>
                    Romanian Deadlift — 3×10<br>
                    Leg Press — 3×12<br>
                    Leg Curls — 3×12<br>
                    Calf Raises — 4×15
                </p>
            </div>
        </div>
    </div>

    <br>

    <div id="intermediate">
        <h2>Intermediate Plan — 5 Days/Week</h2>
        <br>
        <table>
            <thead>
                <tr><th>Day</th><th>Focus</th><th>Main Exercises</th></tr>
            </thead>
            <tbody>
                <tr><td>Monday</td><td>Chest &amp; Triceps</td><td>Bench Press, Incline DB Press, Tricep Pushdown</td></tr>
                <tr><td>Tuesday</td><td>Back &amp; Biceps</td><td>Deadlift, Pull-ups, Rows, Bicep Curls</td></tr>
                <tr><td>Wednesday</td><td>Legs</td><td>Squats, Leg Press, Romanian Deadlift, Calf Raises</td></tr>
                <tr><td>Thursday</td><td>Shoulders</td><td>Overhead Press, Lateral Raises, Face Pulls</td></tr>
                <tr><td>Friday</td><td>Full Body</td><td>Compound movements + accessory work</td></tr>
            </tbody>
        </table>
    </div>

    <br>

    <div id="cardio">
        <h2>Cardio Recommendations</h2>
        <br>
        <div class="cards">
            <div class="card">
                <img src="images/running.jpg" alt="Running">
                <h3>Running</h3>
                <p>30–45 minutes at moderate pace, 3 times per week. Great for overall endurance and fat burning.</p>
            </div>
            <div class="card">
                <img src="images/HIIT-Training.jpg" alt="HIIT">
                <h3>HIIT (High Intensity Interval Training)</h3>
                <p>20 minutes, 30 sec on / 30 sec off. Burpees, jump squats, mountain climbers. Burns more in less time.</p>
            </div>
        </div>
    </div>

    <br>
    <a href="#top">↑ Back to top</a>

</div>

<footer>
    <p>© <?php echo date("Y"); ?> Diamond Gym &mdash; Forged Strength &bull; Unbreakable</p>
    <p><a href="index.php">Home</a> | <a href="nutrition.php">Nutrition</a> | <a href="workouts.php">Workouts</a> | <a href="contact.php">Join Us</a></p>
</footer>

</body>
</html>
