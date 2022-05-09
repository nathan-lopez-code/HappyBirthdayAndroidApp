package net.nathan.vinchou

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import net.nathan.vinchou.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // initialisation of background color
        choseBackgroundColor()

        // launcher animation
        allAnimation()


    }

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


    private fun allAnimation(){
        val myAnimation = AnimationUtils.loadAnimation(this, R.anim.hidden_bg_splash)
        binding.ConstraintChild.startAnimation(myAnimation)

        binding.bottomConstraint.startAnimation(
            AnimationUtils.loadAnimation(this, R.anim.bottom_constraint_apparition)
        )
    }


}