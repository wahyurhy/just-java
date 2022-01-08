package com.wahyurhy.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    String priceMessage = "Thank You!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        if (quantity == 0) {
            displayMessage("Sorry?");
        } else {
            displayPrice(quantity * 5);
            displayMessage(priceMessage);
        }
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    public void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void displayMessage(String message) {
        TextView messageTextView = (TextView) findViewById(R.id.message);
        messageTextView.setText(message);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view) {
        if (quantity <= 0) {
            display(0);
        } else {
            quantity = quantity - 1;
            display(quantity);
        }
    }
}