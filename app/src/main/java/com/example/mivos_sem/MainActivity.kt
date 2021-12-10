package com.example.mivos_sem

import android.app.Application
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import androidx.viewpager.widget.ViewPager
import com.example.mivos_sem.databinding.ActivityMainBinding
import com.example.mivos_sem.ui.main.SectionsPagerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //lateinit var Dishes_db: DishesDatabase
    //Инициализация репозитория и БД
    private val database by lazy { DishesDatabase.getDatabase(this) }
    val repository by lazy { DishesRepository(database.DishesDao()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)


//        val Dishes_db: DishesDatabase = Room.databaseBuilder(
//            applicationContext,
//            DishesDatabase::class.java, "Dishes_db"
//        ).build();

//            val db = Room.databaseBuilder(
//            applicationContext,
//            DishesDatabase::class.java, "Dishes.db"
//        ).build();
//
//        db.DishesDao().insertDish(Dishes(0,"Chicken","Chocken"));

       GlobalScope.launch {
           repository.insert(Dishes(0,"Chicken","Chocken"))
           val test = repository.allDishes.toString();
           //binding.viewPager.findViewById<TextView>(R.id.text1488).setText(repository.allDishes.toString());

       }

        //InsertDish();
        //val dish:Dishes = Dishes(0,"Chicken in acc","Для приготовления курочки требуется две прямые руки, дух приключений, и соседский курятник.");

        //binding.viewPager.findViewById<TextView>(R.id.text1488).setText(Dishes_db.DishesDao().getAll().toString())
        //val fab: FloatingActionButton = binding.fab

//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
    }
//    fun InsertDish(){
//        //Dishes_db.DishesDao().insert(Dishes(0,"Chicken in acc","Для приготовления курочки требуется две прямые руки, дух приключений, и соседский курятник."));
//    }
}