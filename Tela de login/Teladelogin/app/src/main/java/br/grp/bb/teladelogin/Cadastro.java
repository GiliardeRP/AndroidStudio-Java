package br.grp.bb.teladelogin;

import androidx.appcompat.app.AppCompatActivity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Cadastro extends AppCompatActivity {

    TextView usuario;
    TextView senha;
    private final  String ARQUIVO_DB = "ArquivoDB";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        usuario = findViewById(R.id.usuarioCadastro);
        senha = findViewById(R.id.senhaCadastro);

        String nomeUsuario = getIntent().getStringExtra("usuario");
        String senhaUsuario = getIntent().getStringExtra("senha");

        usuario.setText(nomeUsuario);
        senha.setText(senhaUsuario);

        SharedPreferences db = getSharedPreferences(ARQUIVO_DB, 0);
        SharedPreferences.Editor  editorDB = db.edit();

        editorDB.putString("usuarioNome", nomeUsuario);
        editorDB.putString("usuarioSenha", senhaUsuario);
        editorDB.commit();






    }
}