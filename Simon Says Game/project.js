// let div = document.querySelector("div");
// let ul = document.querySelector("ul");
// let lis = document.querySelectorAll("li");



// div.addEventListener("click", function () {
//     console.log("Div was clicked");
// });

// ul.addEventListener("click", function (event) {
//     event.stopPropagation();
//     console.log("ul was clicked");
// });

// for (li of lis){
//     li.addEventListener("click", function (event) {
//         event.stopPropagation();
//         console.log("li was clicked");
//     });
// }



// let btn = document.querySelector("button");
// let ul = document.querySelector("ul");
// let inp = document.querySelector("input");

// btn.addEventListener("click", function () {
//     // console.log(inp.value);
//     let item = document.createElement("li");
//     item.innerText = inp.value;

//     let delBtn = document.querySelector("button");
//     delBtn.innerText= "delete";
//     delBtn.classList.add = "del";

//     item.appendChild(delBtn);
//     ul.append(item);
//     inp.value="";
// });


// ul.addEventListener("click", function (event) {
//     // console.dir(event.target.nodeName);
//     if (event.target.nodeName == "BUTTON"){
//         let listItem = event.target.parentElement;
//         listItem.remove();
//         console.log("Item Deleted");    
//     };
// });

// let button = document.querySelectorAll(".del");
// for (del of button){
//     del.addEventListener("click", function () {
//         let para = this.parentElement;
//         // console.log(para);
//         para.remove();
//     });
// };

// addEventListener("click", function (event) {
//     console.dir(event);
// });

let gameSeq = [];
let userSeq = [];
let btns = ["yellow", "red", "green", "purple"];

let started = false;
let level = 0;
let h3 = document.querySelector("h3");
let highScore = document.querySelector("h4");
let highest_Score = 0;

document.addEventListener("keypress", function () {
    if (started == false){
        console.log("Game Started")
        started = true;
        levelUp();
    }
});

function btnFlash(btn){
    btn.classList.add("flash");
    setTimeout(function () {
        btn.classList.remove("flash");
    },240);
};

function levelUp() {
    userSeq = [];
    level++;
    h3.innerText = `Level ${level}`;

    let randIdx = Math.floor(Math.random() * 3);
    let randColor = btns[randIdx];
    let randBtn = document.querySelector(`.${randColor}`);

    gameSeq.push(randColor);
    console.log(gameSeq);
    btnFlash(randBtn);
};

function checkAns(idx) {
    // let idx = level - 1;

    if (userSeq[idx] === gameSeq[idx]){
        if (userSeq.length == gameSeq.length){
            setTimeout(levelUp, 1000);
        }
    }else {
        let score = level ;
        // h3.innerHTML = `Game over! Your score was <b>${score}</b> <br> Press any key to start`;
        // $("h3").text(`Game over! Your score was <b>${level}</b> <br> Press any key to start`);
        // high score print
        // if (level >= highScore){
        //     // highScore = `Your highest score is ${level}`;
        // highScore.innerText = `Your highest score is ${level}`;
        // let score = level ;   //3
        if (highest_Score <= score){   // 0<=3
            h3.innerHTML = `Game over! Your score was <b>${score}</b> <br> Press any key to start`;
            highScore.innerText = `Your highest score is ${score}`;
            highest_Score = score; // 3
        }else if ( highest_Score >= score){
            h3.innerHTML = `Game over! Your score was <b>${score}</b> <br> Press any key to start`;
            highScore.innerText = `your highest score is ${highest_Score}`;
        }
        // }
        // updateHigh();
        // highScore.innerText = `Your highest score is ${level}`;
        // highScore = level;
        // if (level >= highScore){
        //     highScore = `Your highest score is ${level}`;
        // }
        document.querySelector("body").style.backgroundColor = "red";
        setTimeout(function() {
            document.querySelector("body").style.backgroundColor = "aqua";
        }, 150)
        reset();
    }
}

function btnPress() {
    // console.log(this);
    let btn = this;
    btnFlash(btn);

    let userColor = btn.getAttribute("id");
    userSeq.push(userColor);
    checkAns(userSeq.length-1);
};

let allBtns = document.querySelectorAll(".btn");
for (btn of allBtns){
    btn.addEventListener("click", btnPress);
};

function reset() {
    started = false;
    gameSeq = [];
    userSeq = [];
    level = 0;
};

// function updateHigh(){
//     if (level >= highScore){
//         highScore.innerText = `Your highest score is ${level}`;
//     }else{
//         highScore.innerText= "Not HighScore display";
//     }
// }