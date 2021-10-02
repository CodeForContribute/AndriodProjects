package com.gmail.raushaniiitu.googlepayintegration;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static String payerName, UpiId, msgNote, sendAmount, status;
    public static String GooglePayPackageNAme = "com.google.android.apps.nbu.paisa.user";
    EditText UserName, UPIId, Amount, transactionNote;
    Button PayNow;
    Uri paymentUri;

    private static Uri getUpiPaymentUri(String payerName, String UpiId, String msgNote, String sendAmount) {
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

    public static boolean isAppInstalled(Context conText, String packageName) {
        try {
            conText.getPackageManager().getApplicationInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    private void payWithGooglePay(String packageName) {
        if (isAppInstalled(this, packageName)) {
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(paymentUri);
                intent.setPackage(packageName);
                startActivityForResult(intent, 9999);
            }catch (Exception e){
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Payment Failed, Try after some time or use another payment mode", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(getApplicationContext(), "Google Pay is not installed please install and try Again", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            status = data.getStringExtra("status");
        }
        if (resultCode == RESULT_OK && status.equals("success")) {
            Toast.makeText(getApplicationContext(), "Transaction successful", Toast.LENGTH_LONG).show();
            transactionNote.setText("Transaction of " + sendAmount + "successful");
            transactionNote.setTextColor(Color.GREEN);
        } else {
            Toast.makeText(getApplicationContext(), "Transaction Failed, please try Again after some time", Toast.LENGTH_LONG).show();
            transactionNote.setText("Transaction of " + sendAmount + " failed");
            transactionNote.setTextColor(Color.RED);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserName = findViewById(R.id.user_username_id);
        UPIId = findViewById(R.id.user_upi_id);
        Amount = findViewById(R.id.user_amount_id);
        transactionNote = findViewById(R.id.user_transaction_note_id);
        PayNow = findViewById(R.id.pay_now_btn_id);
        PayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpiId = UPIId.getText().toString();
                payerName = UserName.getText().toString();
                msgNote = transactionNote.getText().toString();
                sendAmount = Amount.getText().toString();
                if (!payerName.equals("") && !UpiId.equals("") && !msgNote.equals("") && !sendAmount.equals("")) {
                    paymentUri = getUpiPaymentUri(payerName, UpiId, msgNote, sendAmount);
                    payWithGooglePay(GooglePayPackageNAme);
                }else{
                    Toast.makeText(getApplicationContext(),"please provide the valid credentials for transaction",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}