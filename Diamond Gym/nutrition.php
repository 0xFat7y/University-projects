<?php session_start(); ?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Nutrition - Diamond Gym</title>
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
        <a href="nutrition.php" class="active">Nutrition</a>
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
    <h1>Nutrition <span>Guide</span></h1>
    <p>Eat right. Fuel your goals.</p>
</div>

<div class="container">

    <p>Jump to: <a href="#macros">Macros</a> | <a href="#meals">Meal Plans</a> | <a href="#table">Food Table</a></p>
    <br>

    <div id="macros">
        <h2>What Are Macros?</h2>
        <p class="section-text">
            Macronutrients (macros) are the three main nutrients your body needs:
            <strong>Protein</strong>, <strong>Carbohydrates</strong>, and <strong>Fats</strong>.
            Getting the right balance is key to reaching your fitness goal.
        </p>
        <br>
        <div class="cards">
            <div class="card">
                <h3>Protein</h3>
                <p>Builds and repairs muscle. Aim for 1.6–2.2g per kg of bodyweight.<br>Sources: chicken, eggs, fish, dairy.</p>
            </div>
            <div class="card">
                <h3>Carbohydrates</h3>
                <p>Your main energy source. Choose complex carbs like rice, oats, and sweet potato.</p>
            </div>
            <div class="card">
                <h3>Fats</h3>
                <p>Essential for hormones and brain function. Choose healthy fats: avocado, nuts, olive oil.</p>
            </div>
        </div>
    </div>

    <br>

    <div id="meals">
        <h2>Sample Meal Plans</h2>
        <br>
        <div class="cards">
            <div class="card">
                <img src="images/muscle-gain-food.jfif" alt="Muscle Gain">
                <h3>Muscle Gain (~3000 kcal)</h3>
                <p>
                     Breakfast: Oats + eggs + banana<br>
                     Lunch: Rice + chicken + veggies<br>
                     Snack: Greek yogurt + nuts<br>
                     Dinner: Salmon + sweet potato
                </p>
            </div>
            <div class="card">
                <img src="images/fat-loss-food.jfif" alt="Fat Loss">
                <h3>Fat Loss (~1800 kcal)</h3>
                <p>
                     Breakfast: Scrambled eggs + avocado<br>
                     Lunch: Salad + tuna<br>
                     Snack: Apple + almonds<br>
                     Dinner: Grilled chicken + broccoli
                </p>
            </div>
        </div>
    </div>

    <br>

    <div id="table">
        <h2>Food Nutrition Table</h2>
        <table>
            <thead>
                <tr>
                    <th>Food</th>
                    <th>Calories (per 100g)</th>
                    <th>Protein (g)</th>
                    <th>Carbs (g)</th>
                    <th>Fat (g)</th>
                </tr>
            </thead>
            <tbody>
                <tr><td>Chicken Breast</td><td>165</td><td>31</td><td>0</td><td>3.6</td></tr>
                <tr><td>Brown Rice</td><td>216</td><td>5</td><td>45</td><td>1.8</td></tr>
                <tr><td>Eggs (whole)</td><td>155</td><td>13</td><td>1.1</td><td>11</td></tr>
                <tr><td>Oats</td><td>389</td><td>17</td><td>66</td><td>7</td></tr>
                <tr><td>Sweet Potato</td><td>86</td><td>1.6</td><td>20</td><td>0.1</td></tr>
                <tr><td>Salmon</td><td>208</td><td>20</td><td>0</td><td>13</td></tr>
                <tr><td>Greek Yogurt</td><td>59</td><td>10</td><td>3.6</td><td>0.4</td></tr>
                <tr><td>Avocado</td><td>160</td><td>2</td><td>9</td><td>15</td></tr>
            </tbody>
        </table>
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
