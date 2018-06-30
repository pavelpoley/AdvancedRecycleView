package pavelpoley.advancedrecycleview.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pavelpoley.advancedrecycleview.R
import pavelpoley.advancedrecycleview.fragments.FeedFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        supportFragmentManager.beginTransaction()
                .add(R.id.content_layout, FeedFragment())
                .commit()
    }
}
