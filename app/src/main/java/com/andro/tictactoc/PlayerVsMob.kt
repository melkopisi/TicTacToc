package com.andro.tictactoc

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_player_vs_mob.*
import java.util.*

class PlayerVsMob : AppCompatActivity(), View.OnClickListener {


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_player_vs_mob)
    //first row
    btn0_0.setOnClickListener(this)
    btn0_1.setOnClickListener(this)
    btn0_2.setOnClickListener(this)
    //second row
    btn1_0.setOnClickListener(this)
    btn1_1.setOnClickListener(this)
    btn1_2.setOnClickListener(this)
    //third row
    btn2_0.setOnClickListener(this)
    btn2_1.setOnClickListener(this)
    btn2_2.setOnClickListener(this)

  }

  override fun onClick(v: View?) {
    val btnSelected = v as Button
    var CellID = 0
    when (btnSelected.id) {
    //first row
      R.id.btn0_0 -> CellID = 1
      R.id.btn0_1 -> CellID = 2
      R.id.btn0_2 -> CellID = 3
    //second row
      R.id.btn1_0 -> CellID = 4
      R.id.btn1_1 -> CellID = 5
      R.id.btn1_2 -> CellID = 6
    //third row
      R.id.btn2_0 -> CellID = 7
      R.id.btn2_1 -> CellID = 8
      R.id.btn2_2 -> CellID = 9
    }
    PlayGame(CellID, btnSelected)
  }

  var playerOne = ArrayList<Int>()
  var playerTwo = ArrayList<Int>()
  var activePlayer = 1

  fun PlayGame(cellID: Int, btnSelected: Button) {
    if (activePlayer == 1) {
      btnSelected.text = "X"
      btnSelected.setBackgroundColor(Color.BLACK)
      btnSelected.setTextColor(Color.WHITE)
      playerOne.add(cellID)
      activePlayer = 2
      AutoPlay()

    } else {
      btnSelected.text = "O"
      btnSelected.setBackgroundColor(Color.RED)
      btnSelected.setTextColor(Color.WHITE)
      playerTwo.add(cellID)
      activePlayer = 1
    }
    btnSelected.isEnabled = false
    Winner()

  }

  fun AutoPlay() {
    var emptyCells = ArrayList<Int>()
    for (cellID in 1..9) {
      if (!(playerOne.contains(cellID) || playerTwo.contains(cellID))) {
        emptyCells.add(cellID)
      }
    }
    val r = Random()
    val randIndex = r.nextInt(emptyCells.size - 0) + 0
    val cellID = emptyCells[randIndex]
    var btnSelect: Button
    when (cellID) {
      1 -> btnSelect = btn0_0
      2 -> btnSelect = btn0_1
      3 -> btnSelect = btn0_2
      4 -> btnSelect = btn1_0
      5 -> btnSelect = btn1_1
      6 -> btnSelect = btn1_2
      7 -> btnSelect = btn2_0
      8 -> btnSelect = btn2_1
      9 -> btnSelect = btn2_2
      else -> {
        btnSelect = btn0_0
      }
    }
    PlayGame(cellID, btnSelect)
  }

  fun Winner() {
    var winner = -1
    var counterA: Int = 0
    var counterB: Int = 0
    //first row
    if (playerOne.contains(1) && playerOne.contains(2) && playerOne.contains(3)) {
      counterA++
      scoreAmob.text = counterA.toString()
      winner = 1
    }
    if (playerTwo.contains(1) && playerTwo.contains(2) && playerTwo.contains(3)) {
      counterB++
      scoreBmob.text = counterB.toString()
      winner = 2
    }
    //second row
    if (playerOne.contains(4) && playerOne.contains(5) && playerOne.contains(6)) {
      counterA++
      scoreAmob.text = counterA.toString()
      winner = 1
    }
    if (playerTwo.contains(4) && playerTwo.contains(5) && playerTwo.contains(6)) {
      counterB++
      scoreBmob.text = counterB.toString()
      winner = 2
    }
    //third row
    if (playerOne.contains(7) && playerOne.contains(8) && playerOne.contains(9)) {
      counterA++
      scoreAmob.text = counterA.toString()
      winner = 1
    }
    if (playerTwo.contains(7) && playerTwo.contains(8) && playerTwo.contains(9)) {
      counterB++
      scoreBmob.text = counterB.toString()
      winner = 2
    }

    //first column
    if (playerOne.contains(1) && playerOne.contains(4) && playerOne.contains(7)) {
      counterA++
      scoreAmob.text = counterA.toString()
      winner = 1
    }
    if (playerTwo.contains(1) && playerTwo.contains(4) && playerTwo.contains(7)) {
      counterB++
      scoreBmob.text = counterB.toString()
      winner = 2
    }
    //second column
    if (playerOne.contains(2) && playerOne.contains(5) && playerOne.contains(8)) {
      counterA++
      scoreAmob.text = counterA.toString()
      winner = 1
    }
    if (playerTwo.contains(2) && playerTwo.contains(5) && playerTwo.contains(8)) {
      counterB++
      scoreBmob.text = counterB.toString()
      winner = 2
    }
    //third column
    if (playerOne.contains(3) && playerOne.contains(6) && playerOne.contains(9)) {
      counterA++
      scoreAmob.text = counterA.toString()
      winner = 1
    }
    if (playerTwo.contains(3) && playerTwo.contains(6) && playerTwo.contains(9)) {
      counterB++
      scoreBmob.text = counterB.toString()
      winner = 2
    }

    //left cross
    if (playerOne.contains(1) && playerOne.contains(5) && playerOne.contains(9)) {
      counterA++
      scoreAmob.text = counterA.toString()
      winner = 1
    }
    if (playerTwo.contains(1) && playerTwo.contains(5) && playerTwo.contains(9)) {
      counterB++
      scoreBmob.text = counterB.toString()
      winner = 2
    }

    //right cross
    if (playerOne.contains(3) && playerOne.contains(5) && playerOne.contains(7)) {
      counterA++
      scoreAmob.text = counterA.toString()
      winner = 1
    }
    if (playerTwo.contains(3) && playerTwo.contains(5) && playerTwo.contains(7)) {
      counterB++
      scoreBmob.text = counterB.toString()
      winner = 2
    }

    if (winner != -1) {
      if (winner == 1) {
        Toast.makeText(applicationContext, "Player One Wins", Toast.LENGTH_LONG).show()
        object : CountDownTimer(3000, 1000) {
          override fun onTick(millisUntilFinished: Long) {
          }

          override fun onFinish() {
            recreate()
          }
        }.start()
      } else {
        Toast.makeText(applicationContext, "Player Two Wins", Toast.LENGTH_LONG).show()
        object : CountDownTimer(3000, 1000) {
          override fun onTick(millisUntilFinished: Long) {
          }

          override fun onFinish() {
            recreate()
          }
        }.start()
      }

    }
  }
}
