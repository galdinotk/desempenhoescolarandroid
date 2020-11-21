package com.example.desempenhoescolarapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class moduloAdministrador extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth = null;
    private FirebaseFirestore banco = null;

    private Button btGU = null;
    private Button btGH = null;
    private Button btLimpar = null;
    private Button btAvancar = null;
    private Button btLimpar2 = null;
    private Button btVoltar = null;
    private Button btSalvar = null;
    private Button btCancelar = null;
    private ImageButton btAdc = null;
    private ImageButton btAlt = null;
    private ImageButton btExc = null;
    private EditText etNome = null;
    private TextView tvNome = null;
    private EditText etEmail = null;
    private TextView tvSenha = null;
    private EditText etSenha = null;
    private TextView tvEmail = null;
    private TextView tvTipo = null;
    private RadioGroup rdTipo = null;
    private RadioButton rdAdmin = null;
    private RadioButton rdProf = null;
    private RadioButton rdAluno = null;
    private TextView tvCargo = null;
    private EditText etCargo = null;
    private TextView tvTurmas = null;
    private TextView tvDisciplinas = null;
    private Spinner spTurma1 = null;
    private Spinner spTurma2 = null;
    private Spinner spTurma3 = null;
    private Spinner spTurma4 = null;
    private Spinner spTurma5 = null;
    private Spinner spDisciplina1 = null;
    private Spinner spDisciplina2 = null;
    private Spinner spDisciplina3 = null;
    private Spinner spDisciplina4 = null;
    private Spinner spDisciplina5 = null;
    private TextView tvTurma = null;
    private Spinner spTurma = null;

    private TextView tvhTurma = null;
    private Spinner sphTurma = null;
    private TextView tvSeg = null;
    private TextView tvTer = null;
    private TextView tvQua = null;
    private TextView tvQui = null;
    private TextView tvSex = null;
    private TextView tvSab = null;
    private EditText etSeg1 = null;
    private EditText etSeg2 = null;
    private EditText etSeg3 = null;
    private EditText etSeg4 = null;
    private EditText etSeg5 = null;
    private EditText etTer1 = null;
    private EditText etTer2 = null;
    private EditText etTer3 = null;
    private EditText etTer4 = null;
    private EditText etTer5 = null;
    private EditText etQua1 = null;
    private EditText etQua2 = null;
    private EditText etQua3 = null;
    private EditText etQua4 = null;
    private EditText etQua5 = null;
    private EditText etQui1 = null;
    private EditText etQui2 = null;
    private EditText etQui3 = null;
    private EditText etQui4 = null;
    private EditText etQui5 = null;
    private EditText etSex1 = null;
    private EditText etSex2 = null;
    private EditText etSex3 = null;
    private EditText etSex4 = null;
    private EditText etSex5 = null;
    private EditText etSab1 = null;
    private EditText etSab2 = null;
    private EditText etSab3 = null;
    private EditText etSab4 = null;
    private EditText etSab5 = null;
    private Button bthSalvar = null;
    private Button bthCarregar = null;
    private ProgressBar progressBar = null;

    private TextView tveNome = null;
    private EditText eteBusca = null;
    private Button bteBuscar = null;
    private Button bteVoltar = null;

    private String tipoUsuario = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo_administrador);
        iniciaComp();
    }

    private void buscaUsuario() {
        banco = FirebaseFirestore.getInstance();
        String nome = eteBusca.getText().toString().trim();
        if (TextUtils.isEmpty(nome)) {
            eteBusca.setError("Você deve digitar o nome completo do usuário");
            return;
        }
        banco.collection("user")
                .whereEqualTo("nome", nome)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.getResult().isEmpty()) {
                            Toast.makeText(moduloAdministrador.this, "Usuário não encontrado!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (task.isSuccessful()) {
                            for (final QueryDocumentSnapshot document : task.getResult()) {
                                banco.collection("user")
                                        .document(document.getId())
                                        .get()
                                        .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                            @Override
                                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                                Usuario u = documentSnapshot.toObject(Usuario.class);
                                                preencheUsuario(u);
                                            }
                                        });
                            }
                        }
                    }
                });
    }


    public void carregaHorarios() {
        bthSalvar.setVisibility(View.VISIBLE);
        limpaHorario();
        String turma = sphTurma.getSelectedItem().toString();
        DocumentReference docSeg = banco.collection("horario").document(turma + " - Segunda");
        DocumentReference docTer = banco.collection("horario").document(turma + " - Terça");
        DocumentReference docQua = banco.collection("horario").document(turma + " - Quarta");
        DocumentReference docQui = banco.collection("horario").document(turma + " - Quinta");
        DocumentReference docSex = banco.collection("horario").document(turma + " - Sexta");
        DocumentReference docSab = banco.collection("horario").document(turma + " - Sabado");

        docSeg.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Horario horario = documentSnapshot.toObject(Horario.class);
                if (horario != null) {
                    etSeg1.setText(horario.getHorario1());
                    etSeg2.setText(horario.getHorario2());
                    etSeg3.setText(horario.getHorario3());
                    etSeg4.setText(horario.getHorario4());
                    etSeg5.setText(horario.getHorario5());
                }
            }
        });

        docTer.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Horario horario = documentSnapshot.toObject(Horario.class);
                if (horario != null) {
                    etTer1.setText(horario.getHorario1());
                    etTer2.setText(horario.getHorario2());
                    etTer3.setText(horario.getHorario3());
                    etTer4.setText(horario.getHorario4());
                    etTer5.setText(horario.getHorario5());
                }
            }
        });

        docQua.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Horario horario = documentSnapshot.toObject(Horario.class);
                if (horario != null) {
                    etQua1.setText(horario.getHorario1());
                    etQua2.setText(horario.getHorario2());
                    etQua3.setText(horario.getHorario3());
                    etQua4.setText(horario.getHorario4());
                    etQua5.setText(horario.getHorario5());
                }
            }
        });

        docQui.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Horario horario = documentSnapshot.toObject(Horario.class);
                if (horario != null) {
                    etQui1.setText(horario.getHorario1());
                    etQui2.setText(horario.getHorario2());
                    etQui3.setText(horario.getHorario3());
                    etQui4.setText(horario.getHorario4());
                    etQui5.setText(horario.getHorario5());
                }
            }
        });

        docSex.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Horario horario = documentSnapshot.toObject(Horario.class);
                if (horario != null) {
                    etSex1.setText(horario.getHorario1());
                    etSex2.setText(horario.getHorario2());
                    etSex3.setText(horario.getHorario3());
                    etSex4.setText(horario.getHorario4());
                    etSex5.setText(horario.getHorario5());
                }
            }
        });

        docSab.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Horario horario = documentSnapshot.toObject(Horario.class);
                if (horario != null) {
                    etSab1.setText(horario.getHorario1());
                    etSab2.setText(horario.getHorario2());
                    etSab3.setText(horario.getHorario3());
                    etSab4.setText(horario.getHorario4());
                    etSab5.setText(horario.getHorario5());
                }
            }
        });
    }

    public void exibeBusca() {
        limpaTela();
        tveNome.setVisibility(View.VISIBLE);
        eteBusca.setVisibility(View.VISIBLE);
        bteBuscar.setVisibility(View.VISIBLE);
        bteVoltar.setVisibility(View.VISIBLE);
    }


    public void exibeGH() {
        limpaTela();
        tvhTurma.setVisibility(View.VISIBLE);
        sphTurma.setVisibility(View.VISIBLE);
        tvSeg.setVisibility(View.VISIBLE);
        tvTer.setVisibility(View.VISIBLE);
        tvQua.setVisibility(View.VISIBLE);
        tvQui.setVisibility(View.VISIBLE);
        tvSex.setVisibility(View.VISIBLE);
        tvSab.setVisibility(View.VISIBLE);
        etSeg1.setVisibility(View.VISIBLE);
        etSeg2.setVisibility(View.VISIBLE);
        etSeg3.setVisibility(View.VISIBLE);
        etSeg4.setVisibility(View.VISIBLE);
        etSeg5.setVisibility(View.VISIBLE);
        etTer1.setVisibility(View.VISIBLE);
        etTer2.setVisibility(View.VISIBLE);
        etTer3.setVisibility(View.VISIBLE);
        etTer4.setVisibility(View.VISIBLE);
        etTer5.setVisibility(View.VISIBLE);
        etQua1.setVisibility(View.VISIBLE);
        etQua2.setVisibility(View.VISIBLE);
        etQua3.setVisibility(View.VISIBLE);
        etQua4.setVisibility(View.VISIBLE);
        etQua5.setVisibility(View.VISIBLE);
        etQui1.setVisibility(View.VISIBLE);
        etQui2.setVisibility(View.VISIBLE);
        etQui3.setVisibility(View.VISIBLE);
        etQui4.setVisibility(View.VISIBLE);
        etQui5.setVisibility(View.VISIBLE);
        etSex1.setVisibility(View.VISIBLE);
        etSex2.setVisibility(View.VISIBLE);
        etSex3.setVisibility(View.VISIBLE);
        etSex4.setVisibility(View.VISIBLE);
        etSex5.setVisibility(View.VISIBLE);
        etSab1.setVisibility(View.VISIBLE);
        etSab2.setVisibility(View.VISIBLE);
        etSab3.setVisibility(View.VISIBLE);
        etSab4.setVisibility(View.VISIBLE);
        etSab5.setVisibility(View.VISIBLE);
        bthCarregar.setVisibility(View.VISIBLE);
    }

    private void exibeGU() {
        limpaTela();
        btAdc.setVisibility(View.VISIBLE);
        btAlt.setVisibility(View.VISIBLE);
        btExc.setVisibility(View.VISIBLE);
    }

    private void exibeGU1() {
        limpaTela();

        etNome.setVisibility(View.VISIBLE);
        tvNome.setVisibility(View.VISIBLE);

        etEmail.setVisibility(View.VISIBLE);
        tvEmail.setVisibility(View.VISIBLE);

        etSenha.setVisibility(View.VISIBLE);
        tvSenha.setVisibility(View.VISIBLE);

        tvTipo.setVisibility(View.VISIBLE);
        rdTipo.setVisibility(View.VISIBLE);
        rdAdmin.setVisibility(View.VISIBLE);
        rdProf.setVisibility(View.VISIBLE);
        rdAluno.setVisibility(View.VISIBLE);

        btLimpar.setVisibility(View.VISIBLE);
        btAvancar.setVisibility(View.VISIBLE);

        btVoltar.setVisibility(View.VISIBLE);

        etSenha.setFocusable(true);
        etEmail.setFocusable(true);
    }

    public void exibeGU2() {
        if (TextUtils.isEmpty(etNome.getText().toString().trim())) {
            etNome.setError("Você deve digitar o nome");
            return;
        }
        if (TextUtils.isEmpty(etEmail.getText().toString().trim())) {
            etEmail.setError("Você deve digitar o e-mail");
            return;
        }
        if (TextUtils.isEmpty(etSenha.getText().toString().trim())) {
            etSenha.setError("Você deve digitar a senha");
            return;
        }
        if (etSenha.getText().toString().trim().length() < 6) {
            etSenha.setError("A senha deve conter 6 caracteres ou mais");
            return;
        }
        if (rdAdmin.isChecked()) {
            tipoUsuario = rdAdmin.getText().toString().trim();
        } else if (rdProf.isChecked()) {
            tipoUsuario = rdProf.getText().toString().trim();
        } else if (rdAluno.isChecked()) {
            tipoUsuario = rdAluno.getText().toString().trim();
        } else {
            rdAdmin.setError("Você deve marcar um destes tipos");
            rdProf.setError("Você deve marcar um destes tipos");
            rdAluno.setError("Você deve marcar um destes tipos");
            return;
        }

        limpaTela();

        if (tipoUsuario.equals("Administrador")) {
            etCargo.setVisibility(View.VISIBLE);
            tvCargo.setVisibility(View.VISIBLE);
        } else if (tipoUsuario.equals("Professor")) {
            tvTurmas.setVisibility(View.VISIBLE);
            tvDisciplinas.setVisibility(View.VISIBLE);
            spTurma1.setVisibility(View.VISIBLE);
            spTurma2.setVisibility(View.VISIBLE);
            spTurma3.setVisibility(View.VISIBLE);
            spTurma4.setVisibility(View.VISIBLE);
            spTurma5.setVisibility(View.VISIBLE);
            spDisciplina1.setVisibility(View.VISIBLE);
            spDisciplina2.setVisibility(View.VISIBLE);
            spDisciplina3.setVisibility(View.VISIBLE);
            spDisciplina4.setVisibility(View.VISIBLE);
            spDisciplina5.setVisibility(View.VISIBLE);
        } else if (tipoUsuario.equals("Aluno")) {
            tvTurma.setVisibility(View.VISIBLE);
            spTurma.setVisibility(View.VISIBLE);
        }
        btVoltar.setVisibility(View.VISIBLE);
        btLimpar2.setVisibility(View.VISIBLE);
        btSalvar.setVisibility(View.VISIBLE);
        btCancelar.setVisibility(View.VISIBLE);
    }

    private void iniciaComp() {
        tipoUsuario = "";

        btGU = (Button) findViewById(R.id.bt_gerencia_usuario);
        btGU.setOnClickListener(this);
        btGH = (Button) findViewById(R.id.bt_gerencia_horarios);
        btGH.setOnClickListener(this);
        btAdc = (ImageButton) findViewById(R.id.bt_add);
        btAdc.setOnClickListener(this);
        btAlt = (ImageButton) findViewById(R.id.bt_alt);
        btAlt.setOnClickListener(this);
        btExc = (ImageButton) findViewById(R.id.bt_del);
        btExc.setOnClickListener(this);

        etNome = (EditText) findViewById(R.id.eta_nome);
        tvNome = (TextView) findViewById(R.id.tva_nome);
        etEmail = (EditText) findViewById(R.id.eta_email);
        tvEmail = (TextView) findViewById(R.id.tva_email);
        etSenha = (EditText) findViewById(R.id.eta_senha);
        tvSenha = (TextView) findViewById(R.id.tva_senha);

        tvTipo = (TextView) findViewById(R.id.tva_tipo);
        rdTipo = (RadioGroup) findViewById(R.id.rd_group_tipo);
        rdAdmin = (RadioButton) findViewById(R.id.rda_administrador);
        rdProf = (RadioButton) findViewById(R.id.rda_professor);
        rdAluno = (RadioButton) findViewById(R.id.rda_aluno);

        btLimpar = (Button) findViewById(R.id.bta_limpar);
        btLimpar.setOnClickListener(this);
        btAvancar = (Button) findViewById(R.id.bta_avancar);
        btAvancar.setOnClickListener(this);

        btVoltar = (Button) findViewById(R.id.bta_voltar);
        btVoltar.setOnClickListener(this);
        btLimpar2 = (Button) findViewById(R.id.bta_limpar2);
        btLimpar2.setOnClickListener(this);
        btSalvar = (Button) findViewById(R.id.bta_salvar);
        btSalvar.setOnClickListener(this);
        btCancelar = (Button) findViewById(R.id.bta_cancelar);
        btCancelar.setOnClickListener(this);

        etCargo = (EditText) findViewById(R.id.eta_cargo);
        tvCargo = (TextView) findViewById(R.id.tva_cargo);

        tvTurmas = (TextView) findViewById(R.id.tva_turmas);
        tvDisciplinas = (TextView) findViewById(R.id.tva_disciplinas);
        spTurma1 = (Spinner) findViewById(R.id.sp_turma1);
        spTurma2 = (Spinner) findViewById(R.id.sp_turma2);
        spTurma3 = (Spinner) findViewById(R.id.sp_turma3);
        spTurma4 = (Spinner) findViewById(R.id.sp_turma4);
        spTurma5 = (Spinner) findViewById(R.id.sp_turma5);
        spDisciplina1 = (Spinner) findViewById(R.id.sp_disciplina1);
        spDisciplina2 = (Spinner) findViewById(R.id.sp_disciplina2);
        spDisciplina3 = (Spinner) findViewById(R.id.sp_disciplina3);
        spDisciplina4 = (Spinner) findViewById(R.id.sp_disciplina4);
        spDisciplina5 = (Spinner) findViewById(R.id.sp_disciplina5);

        tvTurma = (TextView) findViewById(R.id.tva_turma);
        spTurma = (Spinner) findViewById(R.id.sp_turma);

        tvhTurma = (TextView) findViewById(R.id.tvh_turma);
        sphTurma = (Spinner) findViewById(R.id.sph_turma);

        tvSeg = (TextView) findViewById(R.id.tvh_seg);
        tvTer = (TextView) findViewById(R.id.tvh_terca);
        tvQua = (TextView) findViewById(R.id.tvh_quarta);
        tvQui = (TextView) findViewById(R.id.tvh_quinta);
        tvSex = (TextView) findViewById(R.id.tvh_sexta);
        tvSab = (TextView) findViewById(R.id.tvh_sabado);
        etSeg1 = (EditText) findViewById(R.id.eth_seg1);
        etSeg2 = (EditText) findViewById(R.id.eth_seg2);
        etSeg3 = (EditText) findViewById(R.id.eth_seg3);
        etSeg4 = (EditText) findViewById(R.id.eth_seg4);
        etSeg5 = (EditText) findViewById(R.id.eth_seg5);
        etTer1 = (EditText) findViewById(R.id.eth_ter1);
        etTer2 = (EditText) findViewById(R.id.eth_ter2);
        etTer3 = (EditText) findViewById(R.id.eth_ter3);
        etTer4 = (EditText) findViewById(R.id.eth_ter4);
        etTer5 = (EditText) findViewById(R.id.eth_ter5);
        etQua1 = (EditText) findViewById(R.id.eth_qua1);
        etQua2 = (EditText) findViewById(R.id.eth_qua2);
        etQua3 = (EditText) findViewById(R.id.eth_qua3);
        etQua4 = (EditText) findViewById(R.id.eth_qua4);
        etQua5 = (EditText) findViewById(R.id.eth_qua5);
        etQui1 = (EditText) findViewById(R.id.eth_qui1);
        etQui2 = (EditText) findViewById(R.id.eth_qui2);
        etQui3 = (EditText) findViewById(R.id.eth_qui3);
        etQui4 = (EditText) findViewById(R.id.eth_qui4);
        etQui5 = (EditText) findViewById(R.id.eth_qui5);
        etSex1 = (EditText) findViewById(R.id.eth_sex1);
        etSex2 = (EditText) findViewById(R.id.eth_sex2);
        etSex3 = (EditText) findViewById(R.id.eth_sex3);
        etSex4 = (EditText) findViewById(R.id.eth_sex4);
        etSex5 = (EditText) findViewById(R.id.eth_sex5);
        etSab1 = (EditText) findViewById(R.id.eth_sab1);
        etSab2 = (EditText) findViewById(R.id.eth_sab2);
        etSab3 = (EditText) findViewById(R.id.eth_sab3);
        etSab4 = (EditText) findViewById(R.id.eth_sab4);
        etSab5 = (EditText) findViewById(R.id.eth_sab5);
        bthSalvar = (Button) findViewById(R.id.bth_salvar);
        bthSalvar.setOnClickListener(this);
        bthCarregar = (Button) findViewById(R.id.btm_horario);
        bthCarregar.setOnClickListener(this);

        progressBar = (ProgressBar) findViewById(R.id.pb_barra);

        tveNome = (TextView) findViewById(R.id.tve_nome);
        eteBusca = (EditText) findViewById(R.id.ete_busca);
        bteBuscar = (Button) findViewById(R.id.bte_buscar);
        bteBuscar.setOnClickListener(this);
        bteVoltar = (Button) findViewById(R.id.bte_voltar);
        bteVoltar.setOnClickListener(this);

        populaSpinners();
        resetaTela();
    }

    public void limpaCampos1() {
        etNome.setText("");
        etEmail.setText("");
        etSenha.setText("");
        rdAdmin.setChecked(false);
        rdProf.setChecked(false);
        rdAluno.setChecked(false);
    }

    public void limpaCampos2() {
        etCargo.setText("");
        spTurma1.setSelection(0);
        spTurma2.setSelection(0);
        spTurma3.setSelection(0);
        spTurma4.setSelection(0);
        spTurma5.setSelection(0);
        spDisciplina1.setSelection(0);
        spDisciplina2.setSelection(0);
        spDisciplina3.setSelection(0);
        spDisciplina4.setSelection(0);
        spDisciplina5.setSelection(0);
        spTurma.setSelection(0);
    }

    public void limpaHorario() {
        etSeg1.setText("");
        etSeg2.setText("");
        etSeg3.setText("");
        etSeg4.setText("");
        etSeg5.setText("");
        etTer1.setText("");
        etTer2.setText("");
        etTer3.setText("");
        etTer4.setText("");
        etTer5.setText("");
        etQua1.setText("");
        etQua2.setText("");
        etQua3.setText("");
        etQua4.setText("");
        etQua5.setText("");
        etQui1.setText("");
        etQui2.setText("");
        etQui3.setText("");
        etQui4.setText("");
        etQui5.setText("");
        etSex1.setText("");
        etSex2.setText("");
        etSex3.setText("");
        etSex4.setText("");
        etSex5.setText("");
        etSab1.setText("");
        etSab2.setText("");
        etSab3.setText("");
        etSab4.setText("");
        etSab5.setText("");
    }

    public void limpaTela() {
        btGU.setVisibility(View.INVISIBLE);
        btGH.setVisibility(View.INVISIBLE);

        btAdc.setVisibility(View.INVISIBLE);
        btAlt.setVisibility(View.INVISIBLE);
        btExc.setVisibility(View.INVISIBLE);

        etNome.setVisibility(View.INVISIBLE);
        tvNome.setVisibility(View.INVISIBLE);

        etEmail.setVisibility(View.INVISIBLE);
        tvEmail.setVisibility(View.INVISIBLE);

        etSenha.setVisibility(View.INVISIBLE);
        tvSenha.setVisibility(View.INVISIBLE);

        tvTipo.setVisibility(View.INVISIBLE);
        rdTipo.setVisibility(View.INVISIBLE);
        rdAdmin.setVisibility(View.INVISIBLE);
        rdProf.setVisibility(View.INVISIBLE);
        rdAluno.setVisibility(View.INVISIBLE);

        btLimpar.setVisibility(View.INVISIBLE);
        btAvancar.setVisibility(View.INVISIBLE);

        btLimpar2.setVisibility(View.INVISIBLE);
        btVoltar.setVisibility(View.INVISIBLE);
        btSalvar.setVisibility(View.INVISIBLE);
        btCancelar.setVisibility(View.INVISIBLE);

        etCargo.setVisibility(View.INVISIBLE);
        tvCargo.setVisibility(View.INVISIBLE);

        tvTurmas.setVisibility(View.INVISIBLE);
        tvDisciplinas.setVisibility(View.INVISIBLE);
        spTurma1.setVisibility(View.INVISIBLE);
        spTurma2.setVisibility(View.INVISIBLE);
        spTurma3.setVisibility(View.INVISIBLE);
        spTurma4.setVisibility(View.INVISIBLE);
        spTurma5.setVisibility(View.INVISIBLE);
        spDisciplina1.setVisibility(View.INVISIBLE);
        spDisciplina2.setVisibility(View.INVISIBLE);
        spDisciplina3.setVisibility(View.INVISIBLE);
        spDisciplina4.setVisibility(View.INVISIBLE);
        spDisciplina5.setVisibility(View.INVISIBLE);

        tvTurma.setVisibility(View.INVISIBLE);
        spTurma.setVisibility(View.INVISIBLE);

        tvhTurma.setVisibility(View.INVISIBLE);
        sphTurma.setVisibility(View.INVISIBLE);
        tvSeg.setVisibility(View.INVISIBLE);
        tvTer.setVisibility(View.INVISIBLE);
        tvQua.setVisibility(View.INVISIBLE);
        tvQui.setVisibility(View.INVISIBLE);
        tvSex.setVisibility(View.INVISIBLE);
        tvSab.setVisibility(View.INVISIBLE);
        etSeg1.setVisibility(View.INVISIBLE);
        etSeg2.setVisibility(View.INVISIBLE);
        etSeg3.setVisibility(View.INVISIBLE);
        etSeg4.setVisibility(View.INVISIBLE);
        etSeg5.setVisibility(View.INVISIBLE);
        etTer1.setVisibility(View.INVISIBLE);
        etTer2.setVisibility(View.INVISIBLE);
        etTer3.setVisibility(View.INVISIBLE);
        etTer4.setVisibility(View.INVISIBLE);
        etTer5.setVisibility(View.INVISIBLE);
        etQua1.setVisibility(View.INVISIBLE);
        etQua2.setVisibility(View.INVISIBLE);
        etQua3.setVisibility(View.INVISIBLE);
        etQua4.setVisibility(View.INVISIBLE);
        etQua5.setVisibility(View.INVISIBLE);
        etQui1.setVisibility(View.INVISIBLE);
        etQui2.setVisibility(View.INVISIBLE);
        etQui3.setVisibility(View.INVISIBLE);
        etQui4.setVisibility(View.INVISIBLE);
        etQui5.setVisibility(View.INVISIBLE);
        etSex1.setVisibility(View.INVISIBLE);
        etSex2.setVisibility(View.INVISIBLE);
        etSex3.setVisibility(View.INVISIBLE);
        etSex4.setVisibility(View.INVISIBLE);
        etSex5.setVisibility(View.INVISIBLE);
        etSab1.setVisibility(View.INVISIBLE);
        etSab2.setVisibility(View.INVISIBLE);
        etSab3.setVisibility(View.INVISIBLE);
        etSab4.setVisibility(View.INVISIBLE);
        etSab5.setVisibility(View.INVISIBLE);
        bthSalvar.setVisibility(View.INVISIBLE);
        bthCarregar.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.INVISIBLE);

        tveNome.setVisibility(View.INVISIBLE);
        eteBusca.setVisibility(View.INVISIBLE);
        bteBuscar.setVisibility(View.INVISIBLE);
        bteVoltar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_gerencia_usuario:
                exibeGU();
                break;
            case R.id.bt_gerencia_horarios:
                exibeGH();
                break;
            case R.id.bt_add:
                exibeGU1();
                break;
            case R.id.bt_alt:
                exibeBusca();
                break;
            case R.id.bt_del:
                resetaTela();
                break;
            case R.id.bta_limpar:
                limpaCampos1();
                break;
            case R.id.bta_avancar:
                exibeGU2();
                break;
            case R.id.bta_voltar:
                exibeGU1();
                break;
            case R.id.bta_limpar2:
                limpaCampos2();
                break;
            case R.id.bta_cancelar:
                resetaTela();
                break;
            case R.id.bta_salvar:
                salvaUsuario();
                break;
            case R.id.bth_salvar:
                salvaHorario();
                break;
            case R.id.btm_horario:
                carregaHorarios();
                break;
            case R.id.bte_buscar:
                buscaUsuario();
                break;
            case R.id.bte_voltar:
                resetaTela();
                break;
            default:
                break;
        }
    }

    public void populaSpinners() {
        banco = FirebaseFirestore.getInstance();
        CollectionReference refTurmas = banco.collection("turmas");
        CollectionReference refDisciplinas = banco.collection("disciplinas");
        final List<String> turmas = new ArrayList<>();
        final List<String> disciplinas = new ArrayList<>();
        final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, turmas);
        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, disciplinas);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTurma1.setAdapter(adapter1);
        spTurma2.setAdapter(adapter1);
        spTurma3.setAdapter(adapter1);
        spTurma4.setAdapter(adapter1);
        spTurma5.setAdapter(adapter1);
        spTurma.setAdapter(adapter1);
        sphTurma.setAdapter(adapter1);
        spDisciplina1.setAdapter(adapter2);
        spDisciplina2.setAdapter(adapter2);
        spDisciplina3.setAdapter(adapter2);
        spDisciplina4.setAdapter(adapter2);
        spDisciplina5.setAdapter(adapter2);
        refTurmas.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot doc : task.getResult()) {
                        String turma = doc.getString("nome");
                        turmas.add(turma);
                    }
                    adapter1.notifyDataSetChanged();
                }
            }
        });
        refDisciplinas.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot doc : task.getResult()) {
                        String disciplina = doc.getString("nome");
                        disciplinas.add(disciplina);
                    }
                    adapter2.notifyDataSetChanged();
                }
            }
        });
    }

    private void preencheUsuario(Usuario u) {
        etNome.setText(u.getNome());
        etEmail.setText(u.getEmail());
        etEmail.setFocusable(false);
        etSenha.setText(u.getSenha());
        etSenha.setFocusable(false);
        if (u.getTipo().equals("Administrador")) {
            rdAdmin.setChecked(true);
            etCargo.setText(u.getCargo());
        } else if (u.getTipo().equals("Professor")) {
            rdProf.setChecked(true);
            if (u.getTurmas().size() > 0) {
                spTurma1.setSelection(pegaIndexSpinner(spTurma1, (String) u.getTurmas().get(0)));
            }
            if (u.getTurmas().size() > 1) {
                spTurma2.setSelection(pegaIndexSpinner(spTurma2, (String) u.getTurmas().get(1)));
            }
            if (u.getTurmas().size() > 2) {
                spTurma3.setSelection(pegaIndexSpinner(spTurma3, (String) u.getTurmas().get(2)));
            }
            if (u.getTurmas().size() > 3) {
                spTurma4.setSelection(pegaIndexSpinner(spTurma4, (String) u.getTurmas().get(3)));
            }
            if (u.getTurmas().size() > 4) {
                spTurma5.setSelection(pegaIndexSpinner(spTurma5, (String) u.getTurmas().get(4)));
            }
            if (u.getDisciplinas().size() > 0) {
                spDisciplina1.setSelection(pegaIndexSpinner(spDisciplina1, (String) u.getDisciplinas().get(0)));
            }
            if (u.getDisciplinas().size() > 1) {
                spDisciplina2.setSelection(pegaIndexSpinner(spDisciplina2, (String) u.getDisciplinas().get(1)));
            }
            if (u.getDisciplinas().size() > 2) {
                spDisciplina3.setSelection(pegaIndexSpinner(spDisciplina3, (String) u.getDisciplinas().get(2)));
            }
            if (u.getDisciplinas().size() > 3) {
                spDisciplina4.setSelection(pegaIndexSpinner(spDisciplina4, (String) u.getDisciplinas().get(3)));
            }
            if (u.getDisciplinas().size() > 4) {
                spDisciplina5.setSelection(pegaIndexSpinner(spDisciplina5, (String) u.getDisciplinas().get(4)));
            }
        } else if (u.getTipo().equals("Aluno")) {
            rdAluno.setChecked(true);
            spTurma.setSelection(pegaIndexSpinner(spTurma, u.getTurma()));
        }
        exibeGU1();
    }

    private int pegaIndexSpinner(Spinner spinner, String texto) {
        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(texto)) {
                return i;
            }
        }
        return 0;
    }

    private void resetaTela() {
        limpaTela();
        limpaCampos1();
        limpaCampos2();
        limpaHorario();
        btGU.setVisibility(View.VISIBLE);
        btGH.setVisibility(View.VISIBLE);
    }

    private void salvaHorario() {
        banco = FirebaseFirestore.getInstance();
        progressBar.setVisibility(View.VISIBLE);
        if (sphTurma.getSelectedItemPosition() == 0) {
            Toast.makeText(moduloAdministrador.this, "Você deve selecionar uma turma", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.INVISIBLE);
            return;
        }
        final CollectionReference horario = banco.collection("horario");
        final Map<String, Object> horariosSeg = new HashMap<>();
        horariosSeg.put("turma", sphTurma.getSelectedItem().toString());
        horariosSeg.put("horario1", etSeg1.getText().toString().trim());
        horariosSeg.put("horario2", etSeg2.getText().toString().trim());
        horariosSeg.put("horario3", etSeg3.getText().toString().trim());
        horariosSeg.put("horario4", etSeg4.getText().toString().trim());
        horariosSeg.put("horario5", etSeg5.getText().toString().trim());

        horario.document(sphTurma.getSelectedItem().toString() + " - Segunda").set(horariosSeg).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                horario.document(sphTurma.getSelectedItem().toString() + " - Segunda").update(horariosSeg);
            }
        });

        final Map<String, Object> horariosTer = new HashMap<>();
        horariosTer.put("turma", sphTurma.getSelectedItem().toString());
        horariosTer.put("horario1", etTer1.getText().toString().trim());
        horariosTer.put("horario2", etTer2.getText().toString().trim());
        horariosTer.put("horario3", etTer3.getText().toString().trim());
        horariosTer.put("horario4", etTer4.getText().toString().trim());
        horariosTer.put("horario5", etTer5.getText().toString().trim());
        horario.document(sphTurma.getSelectedItem().toString() + " - Terça").set(horariosTer).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                horario.document(sphTurma.getSelectedItem().toString() + " - Terça").update(horariosTer);
            }
        });

        final Map<String, Object> horariosQua = new HashMap<>();
        horariosQua.put("turma", sphTurma.getSelectedItem().toString());
        horariosQua.put("horario1", etQua1.getText().toString().trim());
        horariosQua.put("horario2", etQua2.getText().toString().trim());
        horariosQua.put("horario3", etQua3.getText().toString().trim());
        horariosQua.put("horario4", etQua4.getText().toString().trim());
        horariosQua.put("horario5", etQua5.getText().toString().trim());
        horario.document(sphTurma.getSelectedItem().toString() + " - Quarta").set(horariosQua).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                horario.document(sphTurma.getSelectedItem().toString() + " - Quarta").update(horariosQua);
            }
        });
        final Map<String, Object> horariosQui = new HashMap<>();
        horariosQui.put("turma", sphTurma.getSelectedItem().toString());
        horariosQui.put("horario1", etQui1.getText().toString().trim());
        horariosQui.put("horario2", etQui2.getText().toString().trim());
        horariosQui.put("horario3", etQui3.getText().toString().trim());
        horariosQui.put("horario4", etQui4.getText().toString().trim());
        horariosQui.put("horario5", etQui5.getText().toString().trim());
        horario.document(sphTurma.getSelectedItem().toString() + " - Quinta").set(horariosQui).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                horario.document(sphTurma.getSelectedItem().toString() + " - Quinta").update(horariosQui);
            }
        });
        final Map<String, Object> horariosSex = new HashMap<>();
        horariosSex.put("turma", sphTurma.getSelectedItem().toString());
        horariosSex.put("horario1", etSex1.getText().toString().trim());
        horariosSex.put("horario2", etSex2.getText().toString().trim());
        horariosSex.put("horario3", etSex3.getText().toString().trim());
        horariosSex.put("horario4", etSex4.getText().toString().trim());
        horariosSex.put("horario5", etSex5.getText().toString().trim());
        horario.document(sphTurma.getSelectedItem().toString() + " - Sexta").set(horariosSex).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                horario.document(sphTurma.getSelectedItem().toString() + " - Sexta").update(horariosSex);
            }
        });
        final Map<String, Object> horariosSab = new HashMap<>();
        horariosSab.put("turma", sphTurma.getSelectedItem().toString());
        horariosSab.put("horario1", etSab1.getText().toString().trim());
        horariosSab.put("horario2", etSab2.getText().toString().trim());
        horariosSab.put("horario3", etSab3.getText().toString().trim());
        horariosSab.put("horario4", etSab4.getText().toString().trim());
        horariosSab.put("horario5", etSab5.getText().toString().trim());
        horario.document(sphTurma.getSelectedItem().toString() + " - Sabado").set(horariosSab).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                horario.document(sphTurma.getSelectedItem().toString() + " - Sabado").update(horariosSab);
            }
        });

        Toast.makeText(moduloAdministrador.this, "Horários salvos com sucesso", Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.INVISIBLE);
        resetaTela();
    }

    private void salvaUsuario() {
        final String nome = etNome.getText().toString().trim();
        final String email = etEmail.getText().toString().trim();
        final String senha = etSenha.getText().toString().trim();
        final String cargo = etCargo.getText().toString().trim();
        final ArrayList<String> turmas = new ArrayList<>();
        final ArrayList<String> disciplinas = new ArrayList<>();
        String turma = "";

        if (tipoUsuario.equals("Administrador")) {
            if (TextUtils.isEmpty(cargo)) {
                etCargo.setError("Você deve informar o cargo do administrador");
                return;
            }
        } else if (tipoUsuario.equals("Professor")) {
            if (spTurma1.getSelectedItemPosition() == 0) {
                Toast.makeText(moduloAdministrador.this, "Você deve marcar pelo menos a primeira turma", Toast.LENGTH_SHORT).show();
                return;
            } else {
                turmas.add(spTurma1.getSelectedItem().toString());
            }
            if (spTurma1.getSelectedItemPosition() == 0) {
                Toast.makeText(moduloAdministrador.this, "Você deve marcar pelo menos a primeira disciplina", Toast.LENGTH_SHORT).show();
                return;
            } else {
                disciplinas.add(spDisciplina1.getSelectedItem().toString());
            }
            if (spTurma2.getSelectedItemPosition() > 0) {
                turmas.add(spTurma2.getSelectedItem().toString());
            }
            if (spDisciplina2.getSelectedItemPosition() > 0) {
                disciplinas.add(spDisciplina2.getSelectedItem().toString());
            }
            if (spTurma3.getSelectedItemPosition() > 0) {
                turmas.add(spTurma3.getSelectedItem().toString());
            }
            if (spDisciplina3.getSelectedItemPosition() > 0) {
                disciplinas.add(spDisciplina3.getSelectedItem().toString());
            }
            if (spTurma4.getSelectedItemPosition() > 0) {
                turmas.add(spTurma4.getSelectedItem().toString());
            }
            if (spDisciplina4.getSelectedItemPosition() > 0) {
                disciplinas.add(spDisciplina4.getSelectedItem().toString());
            }
            if (spTurma5.getSelectedItemPosition() > 0) {
                turmas.add(spTurma5.getSelectedItem().toString());
            }
            if (spDisciplina5.getSelectedItemPosition() > 0) {
                disciplinas.add(spDisciplina5.getSelectedItem().toString());
            }
        } else if (tipoUsuario.equals("Aluno")) {
            if (spTurma.getSelectedItemPosition() == 0) {
                Toast.makeText(moduloAdministrador.this, "Você deve marcar selecionar uma turma", Toast.LENGTH_SHORT).show();
                return;
            } else {
                turma = spTurma.getSelectedItem().toString();
            }
        }

        mAuth = FirebaseAuth.getInstance();
        banco = FirebaseFirestore.getInstance();

        final String finalTurma = turma;
        mAuth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    boolean sucesso = false;
                    CollectionReference user = banco.collection("user");
                    Usuario usuario = new Usuario();
                    usuario.setNome(nome);
                    usuario.setEmail(email);
                    usuario.setSenha(senha);
                    usuario.setTipo(tipoUsuario);
                    if (tipoUsuario.equals("Administrador")) {
                        if (!TextUtils.isEmpty(cargo)) {
                            sucesso = true;
                            usuario.setCargo(cargo);
                        }
                    } else if (tipoUsuario.equals("Professor")) {
                        if (!turmas.isEmpty() || disciplinas.isEmpty()) {
                            sucesso = true;
                            usuario.setTurmas(turmas);
                            usuario.setDisciplinas(disciplinas);
                        }
                    } else if (tipoUsuario.equals("Aluno")) {
                        if (!TextUtils.isEmpty(finalTurma)) {
                            sucesso = true;
                            usuario.setTurma(finalTurma);
                            usuario.setBoletim(new Boletim());
                        }
                    }
                    if (sucesso) {
                        user.document(email).set(usuario);
                        Toast.makeText(moduloAdministrador.this, "Usuário " + nome + " salvo com sucesso!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(moduloAdministrador.this, "Ocorreu um erro ao salvar o usuário " + nome, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(moduloAdministrador.this, "O E-mail " + email + " já está cadastrado!", Toast.LENGTH_SHORT).show();
                    }
                });
        resetaTela();
    }


}

