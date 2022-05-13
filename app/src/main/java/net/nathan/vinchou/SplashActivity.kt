package net.nathan.vinchou

import android.annotation.SuppressLint
import android.content.Intent
//import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.TextView
import net.nathan.vinchou.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val myDuration: Long = 6000

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val handler = Handler(Looper.getMainLooper())
        val compt = 6

        // launcher animation
        allAnimation()
        startTimeCounter(binding.compter, compt)

        // launcher the handler
        handler.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, myDuration)

    }

    fun startTimeCounter(text : TextView, compt: Int) {
        object : CountDownTimer(1000, 1000) {
            var comp = compt
            override fun onTick(millisUntilFinished: Long) {
                text.text = comp.toString()
            }
            override fun onFinish() {

                if( comp != 0){
                    comp = comp -1
                }
                startTimeCounter(text, comp)
            }
        }.start()

    }

    /*

    private fun choseBackgroundColor(){
        val currentNightMode = this.resources.configuration.uiMode and
                Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES

        val myConstraint = binding.ConstraintChild
        if(currentNightMode){
            myConstraint.setBackgroundResource(R.color.blue_alpha3)
            binding.mainContainer.setBackgroundResource(R.color.blue_alpha3)

        }else{
            myConstraint.setBackgroundResource(R.color.blue_alpha2)
            binding.mainContainer.setBackgroundResource(R.color.blue_alpha2)
        }
    }

     */

    private fun allAnimation(){
        val myAnimation = AnimationUtils.loadAnimation(this, R.anim.hidden_bg_splash)
        binding.ConstraintChild.startAnimation(myAnimation)

        binding.bottomConstraint.startAnimation(
            AnimationUtils.loadAnimation(this, R.anim.bottom_constraint_apparition)
        )

        binding.compter.startAnimation(
            AnimationUtils.loadAnimation(this, R.anim.app)
        )
        binding.progressBar.startAnimation(
            AnimationUtils.loadAnimation(this, R.anim.app)
        )

    }


}