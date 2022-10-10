package br.grp.bb.teladelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button registar = findViewById(R.id.registrarLogin);
    TextView usuarioLogin = findViewById(R.id.usuarioCadastro);
    TextView senhaLogin = findViewById(R.id.senhaCadastro);
    String bag;
    private final  String ARQUIVO_DB = "ArquivoDB";
    SharedPreferences db = getSharedPreferences(ARQUIVO_DB, 0);




    @Override



    protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.relativelayout);

        usuarioLogin.setText(db.getString("usuarioNome"));
        senhaLogin.setText(db.getString("usuarioSenha"));

            bag = usuarioLogin.getText().toString();

            registar.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {

                    if (usuarioLogin.getText().toString().equals("") || senhaLogin.getText().toString().equals("")) {

                        Toast.makeText(getApplicationContext(), "Usuario ou senha invalidos", Toast.LENGTH_LONG).show();
                    }else{
                        Intent tela = new Intent(MainActivity.this, Cadastro.class);
                    tela.putExtra("usuario", usuarioLogin.getText().toString());
                    tela.putExtra("senha", senhaLogin.getText().toString());
                    startActivity(tela);
                    finish();
                  }
              }
            });
    }
}