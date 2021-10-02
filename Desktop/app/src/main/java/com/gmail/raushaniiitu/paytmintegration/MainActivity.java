package com.gmail.raushaniiitu.paytmintegration;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static String payerName, UpiId, sendAmount, msgNote, status;
    public static String PayTmPackageName = "net.one97.paytm";
    EditText UserName, UPIId, amount, transactionMsg;
    Button payNow;
    Uri paymentUri;

    private static Uri getPaymentUri(String payerName, String UpiId, String sendAmount, String msgNote) {
        return new Uri.Builder()
                .scheme("upi")
                .authority("pay")
                .appendQueryParameter("pa", UpiId)
                .appendQueryParameter("pn", payerName)
                .appendQueryParameter("tn", msgNote)
                .appendQueryParameter("am", sendAmount)
                .appendQueryParameter("cu", "INR")
                .build();
    }

    public boolean isAppInstalled(Context context, String packageName) {
        try {
            context.getPackageManager().getApplicationInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public void payWithPayTm(String packageName) {
        if (isAppInstalled(this, packageName)) {
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(paymentUri);
                startActivityForResult(intent, 9999);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                Toast.makeText(getApplicationContext(), "Paytm Payment Failed", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            status = data.getStringExtra("status");
        }
        if (resultCode == RESULT_OK && status.equals("success")) {
            Toast.makeText(getApplicationContext(), "Transaction Successful", Toast.LENGTH_SHORT).show();
            transactionMsg.setText("Transaction of " + sendAmount + " successful");
            transactionMsg.setTextColor(Color.GREEN);
        } else {
            Toast.makeText(getApplicationContext(), "Transaction Failed ", Toast.LENGTH_LONG).show();
            transactionMsg.setText("Transaction of " + sendAmount + " Failed");
            transactionMsg.setTextColor(Color.GREEN);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserName = findViewById(R.id.user_username_id);
        UPIId = findViewById(R.id.user_upi_id);
        amount = findViewById(R.id.user_amount_id);
        transactionMsg = findViewById(R.id.user_transaction_note_id);
        payNow = findViewById(R.id.pay_now_btn_id);
        payNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                payerName = UserName.getText().toString();
                UpiId = UPIId.getText().toString();
                sendAmount = amount.getText().toString();
                msgNote = transactionMsg.getText().toString();
                if (!payerName.equals("") && !UpiId.equals("") && !sendAmount.equals("") && !msgNote.equals("")) {
                    paymentUri = getPaymentUri(payerName, UpiId, sendAmount, msgNote);
                    payWithPayTm(PayTmPackageName);
                } else {
                    Toast.makeText(getApplicationContext(), "please provide the valid credentials", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}