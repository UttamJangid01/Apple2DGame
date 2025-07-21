# 🍎 Apple 2D Game (Java Swing)

A tile-based 2D game built using Java Swing where the player collects apples while avoiding enemies.
This game includes sound effects, file-based high score tracking, and simple keyboard controls.

🎥 **Watch the full gameplay demo here:**  
https://www.linkedin.com/posts/harsh-jangid-a3093a277_activity-7353118359858671617-ClEU?utm_source=share&utm_medium=member_desktop&rcm=ACoAAEOXmEQBQe-4mvioNevqAH3ZEWW2xcgUWfA

---

## 🎮 Game Overview

- The player moves on a **tile-based grid** using `W`, `A`, `S`, `D` keys.
- There are **4 enemies** that also move horizontal or vertical.
- The objective is to **collect as many apples as possible** before touching any enemy.
- When the player touches an apple:
  - Apple disappears
  - A new apple **spawns at a random (x, y)** position
  - A **"bite" sound** plays
  - Score increases
- When the player **touches an enemy**, the **Game Over screen** appears.

---

## 🧠 Features

- ✅ Tile-based movement system
- 🎮 Player control with `W`, `A`, `S`, `D` keys
- 🤖 Four autonomous enemies with movement logic
- 🍏 Random apple spawning after collection
- 🔊 **Sound effects** using `AudioSystem` (e.g., apple eat sound)
- 📊 **Live score tracking** (top-left corner)
- 💾 **High score storage** using `BufferedReader` & `BufferedWriter`
- 🛑 **Game Over screen** displaying:
  - Your current score
  - Previous best score
  - Restart instruction (`Spacebar`)
- 💥 Exception handling for audio/file issues (`IOException`, `LineUnavailableException`, `UnsupportedAudioFileException`)

---

## ⌨️ Controls

| Action                    | Key        |
|---------------------------|------------|
| Move Up                   | `W`        |
| Move Down                 | `S`        |
| Move Left                 | `A`        |
| Move Right                | `D`        |
| Restart (after Game Over) | `Spacebar` |

---

## 🧰 Tech Stack

- **Java** (Core)
- **Java Swing** (`JFrame`, `JPanel`)
- **KeyListener** for keyboard input
- **Graphics2D** for drawing
- **AudioSystem & Clip** for sound
- **File I/O** using `BufferedReader` and `BufferedWriter` for max score saving
- **Custom exception handling**

---

## 🚀 How to Run

### 📦 Requirements
- Java JDK 8 or above
- Any IDE (like IntelliJ, VS Code with Java Extension)
- Git (if cloning from repo)

### 🧑‍💻 Steps
```bash
# Step 1: Clone the repository
git clone https://github.com/UttamJangid01/Apple2DGame.git

# Step 2: Open the project in your IDE

# Step 3: Run the main class
