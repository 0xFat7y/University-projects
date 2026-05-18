/* ── Original date function (unchanged) ── */
function showDate() {
    var now    = new Date();
    var days   = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];
    var months = ["January","February","March","April","May","June","July","August","September","October","November","December"];
    var result = days[now.getDay()] + ", " + months[now.getMonth()] + " " + now.getDate() + ", " + now.getFullYear();
    document.getElementById("today").textContent = result;
}
showDate();

/* ── Daily motivational quote function ── */
function showDailyQuote() {
    var quotes = [
        { text: "The only bad workout is the one that didn't happen.", author: "Unknown" },
        { text: "Push yourself because no one else is going to do it for you.", author: "Unknown" },
        { text: "Success usually comes to those who are too busy looking for it.", author: "Henry David Thoreau" },
        { text: "All progress takes place outside the comfort zone.", author: "Michael John Bobak" },
        { text: "No pain, no gain. Shut up and train.", author: "Unknown" },
        { text: "The body achieves what the mind believes.", author: "Unknown" },
        { text: "Don't wish for it. Work for it.", author: "Unknown" },
        { text: "Wake up. Work out. Look hot. Kick ass.", author: "Unknown" },
        { text: "Your body can stand almost anything. It's your mind you have to convince.", author: "Unknown" },
        { text: "Take care of your body. It's the only place you have to live.", author: "Jim Rohn" },
        { text: "Strength does not come from the physical capacity. It comes from an indomitable will.", author: "Mahatma Gandhi" },
        { text: "The secret of getting ahead is getting started.", author: "Mark Twain" },
        { text: "Believe you can and you're halfway there.", author: "Theodore Roosevelt" },
        { text: "Train insane or remain the same.", author: "Unknown" },
        { text: "Sweat is just fat crying.", author: "Unknown" },
        { text: "You don't have to be great to start, but you have to start to be great.", author: "Zig Ziglar" },
        { text: "Fitness is not about being better than someone else. It's about being better than you used to be.", author: "Unknown" },
        { text: "It never gets easier, you just get stronger.", author: "Unknown" },
        { text: "Do something today that your future self will thank you for.", author: "Sean Patrick Flanery" },
        { text: "The difference between try and triumph is a little umph.", author: "Marvin Phillips" },
        { text: "Energy and persistence conquer all things.", author: "Benjamin Franklin" },
        { text: "Once you see results, it becomes an addiction.", author: "Unknown" },
        { text: "Fall in love with taking care of yourself.", author: "Unknown" },
        { text: "Be stronger than your strongest excuse.", author: "Unknown" },
        { text: "Your health is an investment, not an expense.", author: "Unknown" },
        { text: "Discipline is doing what needs to be done, even when you don't want to.", author: "Unknown" },
        { text: "Champions aren't made in gyms. Champions are made from something deep inside.", author: "Muhammad Ali" },
        { text: "Pain is temporary. Quitting lasts forever.", author: "Lance Armstrong" },
        { text: "The hard days are the best because that's when champions are made.", author: "Gabby Douglas" },
        { text: "You are one workout away from a good mood.", author: "Unknown" },
        { text: "NO Pain No Gain.", author: "Hazem el Fa7l" },
        { text: "Strive for progress, not perfection.", author: "Unknown" }
    ];

    var dayOfYear = Math.floor((new Date() - new Date(new Date().getFullYear(), 0, 0)) / 86400000);
    var quote     = quotes[dayOfYear % quotes.length];
    var box       = document.getElementById("daily-quote");

    if (box) {
        box.innerHTML =
            "<p>&#8220;" + quote.text + "&#8221;</p>" +
            "<span>— " + quote.author + "</span>";
    }
}
showDailyQuote();
