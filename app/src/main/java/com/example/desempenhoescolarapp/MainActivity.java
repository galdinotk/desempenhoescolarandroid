package com.example.desempenhoescolarapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth = null;
    private FirebaseFirestore banco = null;
    private Button btEntrar = null;
    private EditText etEmail = null;
    private EditText etSenha = null;
    private ProgressBar progressBar = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        banco = FirebaseFirestore.getInstance();
        btEntrar = (Button) findViewById(R.id.btm_horario);
        etEmail = (EditText) findViewById(R.id.et_email);
        etSenha = (EditText) findViewById(R.id.et_senha);
        progressBar = (ProgressBar) findViewById(R.id.pb_barra);
        progressBar.setVisibility(View.INVISIBLE);

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = etEmail.getText().toString().trim();
                String senha = etSenha.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    etEmail.setError("O campo do e-mail não pode estar vazio");
                    return;
                }
                if (TextUtils.isEmpty(senha)) {
                    etSenha.setError("O campo da senha não pode estar vazio");
                    return;
                }
                if (senha.length() < 6) {
                     etEmail.setError("Usuário ou senha inválidos");
                     return;
                }

                progressBar.setVisibility(View.VISIBLE);

                mAuth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.INVISIBLE);
                        etEmail.setText("");
                        etSenha.setText("");
                        if (task.isSuccessful()) {
                            DocumentReference docRef = banco.collection("user").document(email);
                            docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                    Usuario usuario = documentSnapshot.toObject(Usuario.class);
                                    if (usuario.getTipo().equals("Administrador")) {
                                        Intent intent = new Intent(MainActivity.this, moduloAdministrador.class);
                                        //Intent intent = new Intent(MainActivity.this, testes.class);
                                        startActivity(intent);
                                    } else if (usuario.getTipo().equals("Professor")) {
                                        Intent intent = new Intent(MainActivity.this, moduloProfessor.class);
                                        startActivity(intent);
                                    } else if (usuario.getTipo().equals("Aluno")) {
                                        Intent intent = new Intent(MainActivity.this, moduloAluno.class);
                                        intent.putExtra("email",email);
                                        startActivity(intent);
                                    } else {
                                        Intent intent = new Intent(MainActivity.this, erroGeral.class);
                                        startActivity(intent);
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(MainActivity.this, "O seguinte erro o impediu de entrar: "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}