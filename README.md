# Welcome to the game of UNO!

## Description

This project was developed using Java language to simulate a variation of the classic card
game, UNO. It is a basic console based game without a GUI and is played between one player and 
the computer.

## Usage

### Uno Deck Components

The following is a list of components used for the UNO card game:

1. The normal UNO deck contains 108 cards, however this one only has 100 (no reverse cards).

2. The deck contains four Color suits: Red, Blue, Green, Yellow.

3. The Deck contains the following symbols: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, SKIP, DRAWTWO, WILD, 
and WILDDRAWFOUR.

4. The deck consists of the following:
   1. One 0 value card for every color.
   2. Two cards of every other numerical value, 1-9, for every color.
   3. Two SKIP cards for every color.
   4. Two DRAWTWO cards for every color.
   5. Four WILD cards.
   6. Four WILDDRAWFOUR cards.

### UNO Rule Exceptions

This game is played in accordance with the official rules and regulations of UNO EXCEPT for the 
following changes that were implemented in alignment with project scope:

1. No reverse cards - pointless in a game of UNO with two people.

2. If the first card is an "action card" (WILD, WILDDRAWFOUR, DRAWTWO, SKIP), then it is treated 
as a normal card. The color of that card will remain the playable color state. If a variation of 
WILD, then a color will be chosen at random and displayed.

3. If you choose to draw a card, you forfeit the remainder of that turn.

4. WILDDRAWFOUR cards can be played at any time.

### UNO Game Play

In order to start the game, please run the main method in the PlayUno class.

The game begins with a quick Deck test to ensure deck creation and functions are working properly.

The Game Moderator will then create a deck, shuffle it, and deal the first hand. Each player will 
be dealt 7 cards, alternating. The GameModerator will then flip the top card over from the draw pile 
to create the discard pile and will assign that card as the playable card. The GameModerator will 
then announce the game has begun, randomly select the first player, and assign them their turn.

From here, GamePlay will control all user and computer play moves. In the console you will be able 
to see the current playable card as well as any move the computer makes and how that might affect 
you. When it is your turn, the console will show you a list of cards that is your hand along with 
the current playable card in the discard pile. It will ask you which card you would like to play 
from your hand. If you have a playable card, you must enter it into the console EXACTLY AS IT IS 
WRITTEN in your hand. It is case-sensitive. The card will be played and any action associated with 
said card will be analysed and processed accordingly. If you play any variation of WILD card, you 
will be prompted to enter the new color of your choosing. If you do not have a playable card, you 
can type in DRAW. Your hand will be updated with a card drawn from the draw pile and your turn will 
be over.

The player who is able to play their last card wins. 

Once either the computer or player wins, you will be asked if you'd like to play again. If you enter 
Y, a new game will start. If you enter N, the program will terminate.

## Project History

This project was completed by David Drummer, Neten Shrestha, and Nina Woods as a mini project for 
Java Language. Completed in June/2022 through the Amazon SDE apprenticeship via TLG Learning.

## Acknowledgements

A special thanks to Nick Bennett for teaching an excellent course on Java Language in such a short 
time. 
