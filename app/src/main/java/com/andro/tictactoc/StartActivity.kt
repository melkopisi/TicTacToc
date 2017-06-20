package com.andro.tictactoc

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity(), View.OnClickListener {


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_start)
    btnPlayervsMob.setOnClickListener(this)
    btnPlayervsPlayer.setOnClickListener(this)

  }

  override fun onClick(v: View?) {
    if (v == btnPlayervsMob) {
      val goToPlayerVsMob = Intent(this, PlayerVsMob::class.java)
      startActivity(goToPlayerVsMob)

    } else {
      val goToPlayerVsPlayer = Intent(this, PlayerVsPlayer::class.java)
      startActivity(goToPlayerVsPlayer)

    }

  }
}
