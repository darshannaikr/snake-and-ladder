🐍 Snake and Ladder Game (Low-Level Design - Java)
📌 Overview

This project is a command-line based Snake and Ladder game implemented in Java, designed to demonstrate object-oriented design (OOD) principles and clean architecture.

The application simulates a multiplayer turn-based game with support for snakes, ladders, dice rolls, and dynamic player movement.

🚀 Features
🎲 Random dice roll (1–6)
👥 Supports multiple players
🐍 Snake logic (head → tail)
🪜 Ladder logic (start → end)
🔁 Handles chained snake/ladder transitions
🎯 Exact win condition (must reach 100)
📜 Console-based move tracking
🧱 Design & Architecture

The project follows Separation of Concerns and modular design:

🔹 Core Components
Component	Responsibility
Player	Maintains player state (name, position)
Snake	Represents snake (head → tail)
Ladder	Represents ladder (start → end)
Board	Stores snakes & ladders, resolves position
Dice	Generates random dice values
Game	Controls game flow and turn management
Main	Entry point (input handling & execution)

🧠 Key Design Decisions
✅ Used Queue (FIFO) for fair turn-based player rotation
✅ Used HashMap for O(1) lookup of snakes and ladders
✅ Iterative resolution to support chain jumps (snake → ladder → snake)
✅ Modular structure for easy extensibility

📂 Project Structure
src/
└── com/snakeladder/
    ├── model/
    │     ├── Player.java
    │     ├── Snake.java
    │     └── Ladder.java
    │
    ├── board/
    │     └── Board.java
    │
    ├── service/
    │     └── Game.java
    │
    ├── util/
    │     └── Dice.java
    │
    └── main/
          └── Main.java

▶️ How to Run
1️⃣ Clone the Repository
git clone https://github.com/your-username/snake-and-ladder.git
cd snake-and-ladder
2️⃣ Open in IntelliJ IDEA (or any Java IDE)
3️⃣ Run the Main Class

Run:

Main.java
🧾 Input Format
<number_of_snakes>
<head tail>
...

<number_of_ladders>
<start end>
...

<number_of_players>
<player_name>
...
  
📌 Sample Input
2
14 7
31 26
2
3 22
5 8
2
Alice
Bob
  
📤 Sample Output
Alice rolled a 4 and moved from 0 to 4
Bob rolled a 6 and moved from 0 to 6
Alice rolled a 2 and moved from 4 to 6
...
Bob wins the game

⚠️ Game Rules
Board size: 1 to 100
Player starts at position 0
Must land exactly on 100 to win
Dice values range from 1 to 6
Moves exceeding 100 are ignored
Snakes move player down
Ladders move player up
