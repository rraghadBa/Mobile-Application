package com.example.ch7;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class DrinkCategoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);
//The ArrayAdapterDrink.drinks
//android.R.layout.simple_list_item_1 -> displays each item in a the array in a single text
// Drinks.drink -> calls toString() in the Drink class.
        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, Drink.drinks);
//get access to the list view using its ID
        ListView listDrinks = (ListView) findViewById(R.id.list_drinks);
//use the Adapter that has the data, and link it to the ListView
        listDrinks.setAdapter(listAdapter);
//Create the listener
//Interface definition for a callback to be invoked when an item in this AdapterView has been clicked.
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> listDrinks,
                                            View itemView,
                                            int position,
                                            long id) {
//Pass the drink the user clicks on to DrinkActivity
                        Intent intent = new Intent(DrinkCategoryActivity.this,
                                DrinkActivity.class);
//position is the same as the id.
                        intent.putExtra(DrinkActivity.EXTRA_DRINKID, (int) id);
                        startActivity(intent);
                    }
                };
//Assign the listener to the list view
        listDrinks.setOnItemClickListener(itemClickListener);
    }
}