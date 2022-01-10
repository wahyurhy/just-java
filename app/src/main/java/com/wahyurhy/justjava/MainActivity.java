package com.wahyurhy.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String name = "Wahyu Rahayu";
    int quantity = 0;
    int price = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        if (quantity == 0) {
            displayMessage("Sorry?");
        } else {
            String message = createOrderSummary(quantity, hasWhippedCream, hasChocolate);
            displayMessage(message);
        }
    }

    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(numberOfCoffees));
    }

    private int calculatePrice(int price, boolean addWhippedCream, boolean addChocolate) {
        int total = quantity * price;
        if (addWhippedCream) {
            total += (quantity * 2);
        }
        if (addChocolate) {
            total += (quantity * 2);
        }
        return total;
    }

    private String createOrderSummary(int quantity, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + calculatePrice(price, addWhippedCream, addChocolate);
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    public void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity <= 0) {
            displayQuantity(0);
        } else {
            quantity = quantity - 1;
            displayQuantity(quantity);
        }
    }
}