package com.homefilescenter.dynamicrankingplatform.mega.homefilescenterofficial;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Terms extends AppCompatActivity {
    Button tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

        tv=(Button)findViewById(R.id.bf1);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder make=new AlertDialog.Builder(Terms.this);
                make.setTitle("TERMS AND CONDITIONS");

                make.setMessage("Please read these Terms and Conditions (\"Terms\", \"Terms and Conditions\") carefully before using the www.homefilescenter.com website (the \"Service\") operated by HOMEFILESCENTER.\n" +
                        "\n" +
                        "Your access to and use of the Service is conditioned on your acceptance of and compliance with these Terms. These Terms apply to all visitors, users and others who access or use the Service.\n" +
                        "\n" +
                        "By accessing or using the Service you agree to be bound by these Terms. If you disagree with any part of the terms then you may not access the Service.\n" +
                        "\n" +
                        "LINKS TO OTHER WEBSITES\n" +
                        "\n" +
                        "Our Service may contain links to third-party web sites or services that are not owned or controlled by HOMEFILESCENTER.\n" +
                        "\n" +
                        "HOMEFILESCENTER has no control over, and assumes no responsibility for, the content, privacy policies, or practices of any third party web sites or services. You further acknowledge and agree that HOMEFILESCENTER shall not be responsible or liable, directly or indirectly, for any damage or loss caused or alleged to be caused by or in connection with use of or reliance on any such content, goods or services available on or through any such web sites or services.\n" +
                        "\n" +
                        "We strongly advise you to read the terms and conditions and privacy policies of any third-party web sites or services that you visit.\n" +
                        "\n" +
                        "TERMINATION\n" +
                        "\n" +
                        "We may terminate or suspend access to our Service immediately, without prior notice or liability, for any reason whatsoever, including without limitation if you breach the Terms.\n" +
                        "\n" +
                        "All provisions of the Terms which by their nature should survive termination shall survive termination, including, without limitation, ownership provisions, warranty disclaimers, indemnity and limitations of liability.\n" +
                        "\n" +
                        "GOVERNING LAW\n" +
                        "\n" +
                        "These Terms shall be governed and construed in accordance with the laws of Uttar Pradesh, India, without regard to its conflict of law provisions.\n" +
                        "\n" +
                        "Our failure to enforce any right or provision of these Terms will not be considered a waiver of those rights. If any provision of these Terms is held to be invalid or unenforceable by a court, the remaining provisions of these Terms will remain in effect. These Terms constitute the entire agreement between us regarding our Service, and supersede and replace any prior agreements we might have between us regarding the Service.\n" +
                        "\n" +
                        "CHANGES\n" +
                        "\n" +
                        "We reserve the right, at our sole discretion, to modify or replace these Terms at any time. If a revision is material we will try to provide at least 30 days notice prior to any new terms taking effect. What constitutes a material change will be determined at our sole discretion.\n" +
                        "\n" +
                        "By continuing to access or use our Service after those revisions become effective, you agree to be bound by the revised terms. If you do not agree to the new terms, please stop using the Service.\n" +
                        "\n" +
                        "CONTACT US\n" +
                        "\n" +
                        "If you have any questions about these Terms, please contact us.");
                make.setPositiveButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {



                    }
                });

                AlertDialog alert=make.create();
                alert.show();
            }
        });
    }
}

