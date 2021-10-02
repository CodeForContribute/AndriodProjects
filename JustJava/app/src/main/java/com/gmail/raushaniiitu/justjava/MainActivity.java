package com.gmail.raushaniiitu.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.text.Editable;
import android.util.Log;
import android.view.View;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private int numberOfCoffee;
    private int rate_per_cupOfCoffee = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        EditText quantityOfItem = findViewById(R.id.quantity_number_id);
        String item = quantityOfItem.getText().toString();
        if(item.length() > 6){
            quantityOfItem.setError("Can not enter more than 6 digits");
        }else {
            try {
                numberOfCoffee = Integer.parseInt(item);
                calculateTotalPrice();
            } catch (NumberFormatException e) {
                System.out.println(e.toString());
                quantityOfItem.setError("please enter quantity in number only");
            }
        }
    }

    public void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_number_id);
    }

    public void calculateTotalPrice() {
        TextView priceTextView = findViewById(R.id.price_number_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(numberOfCoffee * rate_per_cupOfCoffee));
    }
    public void incrementOrderQuantity(View view){
        EditText editText = findViewById(R.id.quantity_number_id);
        String orderNumber = editText.getText().toString();
        if(orderNumber.length() == 0){
            numberOfCoffee = 0;
        }else{
            numberOfCoffee = Integer.parseInt(orderNumber);
            numberOfCoffee++;
        }
        editText.setText(String.valueOf(numberOfCoffee));
    }

    public void decrementOrderQuantity(View view){
        EditText editText = findViewById(R.id.quantity_number_id);
        String orderNumber = editText.getText().toString();
        if(orderNumber.length() == 0){
            System.out.println("The order quantity is empty!!");
            //numberOfCoffee = 0;
            //do nothing
        }else if(orderNumber.length() > 0){
            numberOfCoffee = Integer.parseInt(orderNumber);
            if(numberOfCoffee > 0){
                numberOfCoffee--;
                editText.setText(String.valueOf(numberOfCoffee));
            }
        }

    }
}