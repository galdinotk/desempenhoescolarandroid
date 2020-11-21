package com.example.desempenhoescolarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class moduloAluno extends AppCompatActivity implements View.OnClickListener {

    private FirebaseFirestore banco = null;

    private Button btDesempenho = null;
    private Button btHorario = null;

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
    private Button bthVoltar = null;

    private TextView tvdBoletim = null;
    private TextView tvdT1 = null;
    private TextView tvdT2 = null;
    private TextView tvdT3 = null;
    private TextView tvdFinal = null;
    private TextView tvdArt = null;
    private TextView tvdCie = null;
    private TextView tvdEF = null;
    private TextView tvdER = null;
    private TextView tvdGeo = null;
    private TextView tvdHis = null;
    private TextView tvdIng = null;
    private TextView tvdMat = null;
    private TextView tvdPor = null;
    private TextView tvdN1 = null;
    private TextView tvdF1 = null;
    private TextView tvdN2 = null;
    private TextView tvdF2 = null;
    private TextView tvdN3 = null;
    private TextView tvdF3 = null;
    private TextView tvdNF = null;
    private TextView tvdFF = null;
    private EditText edArtN1 = null;
    private EditText edArtF1 = null;
    private EditText edArtN2 = null;
    private EditText edArtF2 = null;
    private EditText edArtN3 = null;
    private EditText edArtF3 = null;
    private EditText edArtNF = null;
    private EditText edArtFF = null;
    private EditText edCieN1 = null;
    private EditText edCieF1 = null;
    private EditText edCieN2 = null;
    private EditText edCieF2 = null;
    private EditText edCieN3 = null;
    private EditText edCieF3 = null;
    private EditText edCieNF = null;
    private EditText edCieFF = null;
    private EditText edEFN1 = null;
    private EditText edEFF1 = null;
    private EditText edEFN2 = null;
    private EditText edEFF2 = null;
    private EditText edEFN3 = null;
    private EditText edEFF3 = null;
    private EditText edEFNF = null;
    private EditText edEFFF = null;
    private EditText edERN1 = null;
    private EditText edERF1 = null;
    private EditText edERN2 = null;
    private EditText edERF2 = null;
    private EditText edERN3 = null;
    private EditText edERF3 = null;
    private EditText edERNF = null;
    private EditText edERFF = null;
    private EditText edGeoN1 = null;
    private EditText edGeoF1 = null;
    private EditText edGeoN2 = null;
    private EditText edGeoF2 = null;
    private EditText edGeoN3 = null;
    private EditText edGeoF3 = null;
    private EditText edGeoNF = null;
    private EditText edGeoFF = null;
    private EditText edHisN1 = null;
    private EditText edHisF1 = null;
    private EditText edHisN2 = null;
    private EditText edHisF2 = null;
    private EditText edHisN3 = null;
    private EditText edHisF3 = null;
    private EditText edHisNF = null;
    private EditText edHisFF = null;
    private EditText edIngN1 = null;
    private EditText edIngF1 = null;
    private EditText edIngN2 = null;
    private EditText edIngF2 = null;
    private EditText edIngN3 = null;
    private EditText edIngF3 = null;
    private EditText edIngNF = null;
    private EditText edIngFF = null;
    private EditText edMatN1 = null;
    private EditText edMatF1 = null;
    private EditText edMatN2 = null;
    private EditText edMatF2 = null;
    private EditText edMatN3 = null;
    private EditText edMatF3 = null;
    private EditText edMatNF = null;
    private EditText edMatFF = null;
    private EditText edPorN1 = null;
    private EditText edPorF1 = null;
    private EditText edPorN2 = null;
    private EditText edPorF2 = null;
    private EditText edPorN3 = null;
    private EditText edPorF3 = null;
    private EditText edPorNF = null;
    private EditText edPorFF = null;


    private String turma = null;
    private String email = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo_aluno);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            email = extras.getString("email");
        }
        pegaTurma();
        iniciaComp();
        resetaTela();

    }

    private void carregaBoletim() {
    }

    public void carregaHorarios() {
        banco = FirebaseFirestore.getInstance();
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

    private void exibeHorario() {
        limpaTela();
        carregaHorarios();
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
        bthVoltar.setVisibility(View.VISIBLE);
    }

    private void exibeDesempenho() {
        limpaTela();
        carregaBoletim();
        bthVoltar.setVisibility(View.VISIBLE);
        tvdBoletim.setVisibility(View.VISIBLE);
        tvdT1.setVisibility(View.VISIBLE);
        tvdT2.setVisibility(View.VISIBLE);
        tvdT3.setVisibility(View.VISIBLE);
        tvdFinal.setVisibility(View.VISIBLE);
        tvdArt.setVisibility(View.VISIBLE);
        tvdCie.setVisibility(View.VISIBLE);
        tvdEF.setVisibility(View.VISIBLE);
        tvdER.setVisibility(View.VISIBLE);
        tvdGeo.setVisibility(View.VISIBLE);
        tvdHis.setVisibility(View.VISIBLE);
        tvdIng.setVisibility(View.VISIBLE);
        tvdMat.setVisibility(View.VISIBLE);
        tvdPor.setVisibility(View.VISIBLE);
        tvdN1.setVisibility(View.VISIBLE);
        tvdF1.setVisibility(View.VISIBLE);
        tvdN2.setVisibility(View.VISIBLE);
        tvdF2.setVisibility(View.VISIBLE);
        tvdN3.setVisibility(View.VISIBLE);
        tvdF3.setVisibility(View.VISIBLE);
        tvdNF.setVisibility(View.VISIBLE);
        tvdFF.setVisibility(View.VISIBLE);
        edArtN1.setVisibility(View.VISIBLE);
        edArtF1.setVisibility(View.VISIBLE);
        edArtN2.setVisibility(View.VISIBLE);
        edArtF2.setVisibility(View.VISIBLE);
        edArtN3.setVisibility(View.VISIBLE);
        edArtF3.setVisibility(View.VISIBLE);
        edArtNF.setVisibility(View.VISIBLE);
        edArtFF.setVisibility(View.VISIBLE);
        edCieN1.setVisibility(View.VISIBLE);
        edCieF1.setVisibility(View.VISIBLE);
        edCieN2.setVisibility(View.VISIBLE);
        edCieF2.setVisibility(View.VISIBLE);
        edCieN3.setVisibility(View.VISIBLE);
        edCieF3.setVisibility(View.VISIBLE);
        edCieNF.setVisibility(View.VISIBLE);
        edCieFF.setVisibility(View.VISIBLE);
        edEFN1.setVisibility(View.VISIBLE);
        edEFF1.setVisibility(View.VISIBLE);
        edEFN2.setVisibility(View.VISIBLE);
        edEFF2.setVisibility(View.VISIBLE);
        edEFN3.setVisibility(View.VISIBLE);
        edEFF3.setVisibility(View.VISIBLE);
        edEFNF.setVisibility(View.VISIBLE);
        edEFFF.setVisibility(View.VISIBLE);
        edERN1.setVisibility(View.VISIBLE);
        edERF1.setVisibility(View.VISIBLE);
        edERN2.setVisibility(View.VISIBLE);
        edERF2.setVisibility(View.VISIBLE);
        edERN3.setVisibility(View.VISIBLE);
        edERF3.setVisibility(View.VISIBLE);
        edERNF.setVisibility(View.VISIBLE);
        edERFF.setVisibility(View.VISIBLE);
        edGeoN1.setVisibility(View.VISIBLE);
        edGeoF1.setVisibility(View.VISIBLE);
        edGeoN2.setVisibility(View.VISIBLE);
        edGeoF2.setVisibility(View.VISIBLE);
        edGeoN3.setVisibility(View.VISIBLE);
        edGeoF3.setVisibility(View.VISIBLE);
        edGeoNF.setVisibility(View.VISIBLE);
        edGeoFF.setVisibility(View.VISIBLE);
        edHisN1.setVisibility(View.VISIBLE);
        edHisF1.setVisibility(View.VISIBLE);
        edHisN2.setVisibility(View.VISIBLE);
        edHisF2.setVisibility(View.VISIBLE);
        edHisN3.setVisibility(View.VISIBLE);
        edHisF3.setVisibility(View.VISIBLE);
        edHisNF.setVisibility(View.VISIBLE);
        edHisFF.setVisibility(View.VISIBLE);
        edIngN1.setVisibility(View.VISIBLE);
        edIngF1.setVisibility(View.VISIBLE);
        edIngN2.setVisibility(View.VISIBLE);
        edIngF2.setVisibility(View.VISIBLE);
        edIngN3.setVisibility(View.VISIBLE);
        edIngF3.setVisibility(View.VISIBLE);
        edIngNF.setVisibility(View.VISIBLE);
        edIngFF.setVisibility(View.VISIBLE);
        edMatN1.setVisibility(View.VISIBLE);
        edMatF1.setVisibility(View.VISIBLE);
        edMatN2.setVisibility(View.VISIBLE);
        edMatF2.setVisibility(View.VISIBLE);
        edMatN3.setVisibility(View.VISIBLE);
        edMatF3.setVisibility(View.VISIBLE);
        edMatNF.setVisibility(View.VISIBLE);
        edMatFF.setVisibility(View.VISIBLE);
        edPorN1.setVisibility(View.VISIBLE);
        edPorF1.setVisibility(View.VISIBLE);
        edPorN2.setVisibility(View.VISIBLE);
        edPorF2.setVisibility(View.VISIBLE);
        edPorN3.setVisibility(View.VISIBLE);
        edPorF3.setVisibility(View.VISIBLE);
        edPorNF.setVisibility(View.VISIBLE);
        edPorFF.setVisibility(View.VISIBLE);
    }

    private void iniciaComp() {
        btDesempenho = (Button) findViewById(R.id.btm_desempenho);
        btDesempenho.setOnClickListener(this);
        btHorario = (Button) findViewById(R.id.btm_horario);
        btHorario.setOnClickListener(this);

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
        tvSeg = (TextView) findViewById(R.id.tvh_seg);
        tvTer = (TextView) findViewById(R.id.tvh_terca);
        tvQua = (TextView) findViewById(R.id.tvh_quarta);
        tvQui = (TextView) findViewById(R.id.tvh_quinta);
        tvSex = (TextView) findViewById(R.id.tvh_sexta);
        tvSab = (TextView) findViewById(R.id.tvh_sabado);

        etSeg1.setFocusable(false);
        etSeg2.setFocusable(false);
        etSeg3.setFocusable(false);
        etSeg4.setFocusable(false);
        etSeg5.setFocusable(false);
        etTer1.setFocusable(false);
        etTer2.setFocusable(false);
        etTer3.setFocusable(false);
        etTer4.setFocusable(false);
        etTer5.setFocusable(false);
        etQua1.setFocusable(false);
        etQua2.setFocusable(false);
        etQua3.setFocusable(false);
        etQua4.setFocusable(false);
        etQua5.setFocusable(false);
        etQui1.setFocusable(false);
        etQui2.setFocusable(false);
        etQui3.setFocusable(false);
        etQui4.setFocusable(false);
        etQui5.setFocusable(false);
        etSex1.setFocusable(false);
        etSex2.setFocusable(false);
        etSex3.setFocusable(false);
        etSex4.setFocusable(false);
        etSex5.setFocusable(false);
        etSab1.setFocusable(false);
        etSab2.setFocusable(false);
        etSab3.setFocusable(false);
        etSab4.setFocusable(false);
        etSab5.setFocusable(false);
        bthVoltar = (Button) findViewById(R.id.bte_buscar);
        bthVoltar.setOnClickListener(this);

        tvdBoletim = (TextView) findViewById(R.id.tvd_boletim);
        tvdT1 = (TextView) findViewById(R.id.tvd_t1);
        tvdT2 = (TextView) findViewById(R.id.tvd_t2);
        tvdT3 = (TextView) findViewById(R.id.tvd_t3);
        tvdFinal = (TextView) findViewById(R.id.tvd_final);
        tvdArt = (TextView) findViewById(R.id.tvd_art);
        tvdCie = (TextView) findViewById(R.id.tvd_cie);
        tvdEF = (TextView) findViewById(R.id.tvd_ef);
        tvdER = (TextView) findViewById(R.id.tvd_er);
        tvdGeo = (TextView) findViewById(R.id.tvd_geo);
        tvdHis = (TextView) findViewById(R.id.tvd_his);
        tvdIng = (TextView) findViewById(R.id.tvd_ing);
        tvdMat = (TextView) findViewById(R.id.tvd_mat);
        tvdPor = (TextView) findViewById(R.id.tvd_por);
        tvdN1 = (TextView) findViewById(R.id.tvd_n1);
        tvdF1 = (TextView) findViewById(R.id.tvd_f1);
        tvdN2 = (TextView) findViewById(R.id.tvd_n2);
        tvdF2 = (TextView) findViewById(R.id.tvd_f2);
        tvdN3 = (TextView) findViewById(R.id.tvd_n3);
        tvdF3 = (TextView) findViewById(R.id.tvd_f3);
        tvdNF = (TextView) findViewById(R.id.tvd_nf);
        tvdFF = (TextView) findViewById(R.id.tvd_ff);
        edArtN1 = (EditText) findViewById(R.id.etd_artn1);
        edArtF1 = (EditText) findViewById(R.id.etd_artf1);
        edArtN2 = (EditText) findViewById(R.id.etd_artn2);
        edArtF2 = (EditText) findViewById(R.id.etd_artf2);
        edArtN3 = (EditText) findViewById(R.id.etd_artn3);
        edArtF3 = (EditText) findViewById(R.id.etd_artf3);
        edArtNF = (EditText) findViewById(R.id.etd_artnf);
        edArtFF = (EditText) findViewById(R.id.etd_artff);
        edCieN1 = (EditText) findViewById(R.id.etd_cien1);
        edCieF1 = (EditText) findViewById(R.id.etd_cief1);
        edCieN2 = (EditText) findViewById(R.id.etd_cien2);
        edCieF2 = (EditText) findViewById(R.id.etd_cief2);
        edCieN3 = (EditText) findViewById(R.id.etd_cien3);
        edCieF3 = (EditText) findViewById(R.id.etd_cief3);
        edCieNF = (EditText) findViewById(R.id.etd_cienf);
        edCieFF = (EditText) findViewById(R.id.etd_cieff);
        edEFN1 = (EditText) findViewById(R.id.etd_efn1);
        edEFF1 = (EditText) findViewById(R.id.etd_eff1);
        edEFN2 = (EditText) findViewById(R.id.etd_efn2);
        edEFF2 = (EditText) findViewById(R.id.etd_eff2);
        edEFN3 = (EditText) findViewById(R.id.etd_efn3);
        edEFF3 = (EditText) findViewById(R.id.etd_eff3);
        edEFNF = (EditText) findViewById(R.id.etd_efnf);
        edEFFF = (EditText) findViewById(R.id.etd_efff);
        edERN1 = (EditText) findViewById(R.id.etd_ern1);
        edERF1 = (EditText) findViewById(R.id.etd_erf1);
        edERN2 = (EditText) findViewById(R.id.etd_ern2);
        edERF2 = (EditText) findViewById(R.id.etd_erf2);
        edERN3 = (EditText) findViewById(R.id.etd_ern3);
        edERF3 = (EditText) findViewById(R.id.etd_erf3);
        edERNF = (EditText) findViewById(R.id.etd_ernf);
        edERFF = (EditText) findViewById(R.id.etd_erff);
        edGeoN1 = (EditText) findViewById(R.id.etd_geon1);
        edGeoF1 = (EditText) findViewById(R.id.etd_geof1);
        edGeoN2 = (EditText) findViewById(R.id.etd_geon2);
        edGeoF2 = (EditText) findViewById(R.id.etd_geof2);
        edGeoN3 = (EditText) findViewById(R.id.etd_geon3);
        edGeoF3 = (EditText) findViewById(R.id.etd_geof3);
        edGeoNF = (EditText) findViewById(R.id.etd_geonf);
        edGeoFF = (EditText) findViewById(R.id.etd_geoff);
        edHisN1 = (EditText) findViewById(R.id.etd_hisn1);
        edHisF1 = (EditText) findViewById(R.id.etd_hisf1);
        edHisN2 = (EditText) findViewById(R.id.etd_hisn2);
        edHisF2 = (EditText) findViewById(R.id.etd_hisf2);
        edHisN3 = (EditText) findViewById(R.id.etd_hisn3);
        edHisF3 = (EditText) findViewById(R.id.etd_hisf3);
        edHisNF = (EditText) findViewById(R.id.etd_hisnf);
        edHisFF = (EditText) findViewById(R.id.etd_hisff);
        edIngN1 = (EditText) findViewById(R.id.etd_ingn1);
        edIngF1 = (EditText) findViewById(R.id.etd_ingf1);
        edIngN2 = (EditText) findViewById(R.id.etd_ingn2);
        edIngF2 = (EditText) findViewById(R.id.etd_ingf2);
        edIngN3 = (EditText) findViewById(R.id.etd_ingn3);
        edIngF3 = (EditText) findViewById(R.id.etd_ingf3);
        edIngNF = (EditText) findViewById(R.id.etd_ingnf);
        edIngFF = (EditText) findViewById(R.id.etd_ingff);
        edMatN1 = (EditText) findViewById(R.id.etd_matn1);
        edMatF1 = (EditText) findViewById(R.id.etd_matf1);
        edMatN2 = (EditText) findViewById(R.id.etd_matn2);
        edMatF2 = (EditText) findViewById(R.id.etd_matf2);
        edMatN3 = (EditText) findViewById(R.id.etd_matn3);
        edMatF3 = (EditText) findViewById(R.id.etd_matf3);
        edMatNF = (EditText) findViewById(R.id.etd_matnf);
        edMatFF = (EditText) findViewById(R.id.etd_matff);
        edPorN1 = (EditText) findViewById(R.id.etd_porn1);
        edPorF1 = (EditText) findViewById(R.id.etd_porf1);
        edPorN2 = (EditText) findViewById(R.id.etd_porn2);
        edPorF2 = (EditText) findViewById(R.id.etd_porf2);
        edPorN3 = (EditText) findViewById(R.id.etd_porn3);
        edPorF3 = (EditText) findViewById(R.id.etd_porf3);
        edPorNF = (EditText) findViewById(R.id.etd_pornf);
        edPorFF = (EditText) findViewById(R.id.etd_porff);

        edArtN1.setFocusable(false);
        edArtF1.setFocusable(false);
        edArtN2.setFocusable(false);
        edArtF2.setFocusable(false);
        edArtN3.setFocusable(false);
        edArtF3.setFocusable(false);
        edArtNF.setFocusable(false);
        edArtFF.setFocusable(false);
        edCieN1.setFocusable(false);
        edCieF1.setFocusable(false);
        edCieN2.setFocusable(false);
        edCieF2.setFocusable(false);
        edCieN3.setFocusable(false);
        edCieF3.setFocusable(false);
        edCieNF.setFocusable(false);
        edCieFF.setFocusable(false);
        edEFN1.setFocusable(false);
        edEFF1.setFocusable(false);
        edEFN2.setFocusable(false);
        edEFF2.setFocusable(false);
        edEFN3.setFocusable(false);
        edEFF3.setFocusable(false);
        edEFNF.setFocusable(false);
        edEFFF.setFocusable(false);
        edERN1.setFocusable(false);
        edERF1.setFocusable(false);
        edERN2.setFocusable(false);
        edERF2.setFocusable(false);
        edERN3.setFocusable(false);
        edERF3.setFocusable(false);
        edERNF.setFocusable(false);
        edERFF.setFocusable(false);
        edGeoN1.setFocusable(false);
        edGeoF1.setFocusable(false);
        edGeoN2.setFocusable(false);
        edGeoF2.setFocusable(false);
        edGeoN3.setFocusable(false);
        edGeoF3.setFocusable(false);
        edGeoNF.setFocusable(false);
        edGeoFF.setFocusable(false);
        edHisN1.setFocusable(false);
        edHisF1.setFocusable(false);
        edHisN2.setFocusable(false);
        edHisF2.setFocusable(false);
        edHisN3.setFocusable(false);
        edHisF3.setFocusable(false);
        edHisNF.setFocusable(false);
        edHisFF.setFocusable(false);
        edIngN1.setFocusable(false);
        edIngF1.setFocusable(false);
        edIngN2.setFocusable(false);
        edIngF2.setFocusable(false);
        edIngN3.setFocusable(false);
        edIngF3.setFocusable(false);
        edIngNF.setFocusable(false);
        edIngFF.setFocusable(false);
        edMatN1.setFocusable(false);
        edMatF1.setFocusable(false);
        edMatN2.setFocusable(false);
        edMatF2.setFocusable(false);
        edMatN3.setFocusable(false);
        edMatF3.setFocusable(false);
        edMatNF.setFocusable(false);
        edMatFF.setFocusable(false);
        edPorN1.setFocusable(false);
        edPorF1.setFocusable(false);
        edPorN2.setFocusable(false);
        edPorF2.setFocusable(false);
        edPorN3.setFocusable(false);
        edPorF3.setFocusable(false);
        edPorNF.setFocusable(false);
        edPorFF.setFocusable(false);

    }

    private void limpaTela() {
        btDesempenho.setVisibility(View.INVISIBLE);
        btHorario.setVisibility(View.INVISIBLE);

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
        bthVoltar.setVisibility(View.INVISIBLE);

        tvdBoletim.setVisibility(View.INVISIBLE);
        tvdT1.setVisibility(View.INVISIBLE);
        tvdT2.setVisibility(View.INVISIBLE);
        tvdT3.setVisibility(View.INVISIBLE);
        tvdFinal.setVisibility(View.INVISIBLE);
        tvdArt.setVisibility(View.INVISIBLE);
        tvdCie.setVisibility(View.INVISIBLE);
        tvdEF.setVisibility(View.INVISIBLE);
        tvdER.setVisibility(View.INVISIBLE);
        tvdGeo.setVisibility(View.INVISIBLE);
        tvdHis.setVisibility(View.INVISIBLE);
        tvdIng.setVisibility(View.INVISIBLE);
        tvdMat.setVisibility(View.INVISIBLE);
        tvdPor.setVisibility(View.INVISIBLE);
        tvdN1.setVisibility(View.INVISIBLE);
        tvdF1.setVisibility(View.INVISIBLE);
        tvdN2.setVisibility(View.INVISIBLE);
        tvdF2.setVisibility(View.INVISIBLE);
        tvdN3.setVisibility(View.INVISIBLE);
        tvdF3.setVisibility(View.INVISIBLE);
        tvdNF.setVisibility(View.INVISIBLE);
        tvdFF.setVisibility(View.INVISIBLE);
        edArtN1.setVisibility(View.INVISIBLE);
        edArtF1.setVisibility(View.INVISIBLE);
        edArtN2.setVisibility(View.INVISIBLE);
        edArtF2.setVisibility(View.INVISIBLE);
        edArtN3.setVisibility(View.INVISIBLE);
        edArtF3.setVisibility(View.INVISIBLE);
        edArtNF.setVisibility(View.INVISIBLE);
        edArtFF.setVisibility(View.INVISIBLE);
        edCieN1.setVisibility(View.INVISIBLE);
        edCieF1.setVisibility(View.INVISIBLE);
        edCieN2.setVisibility(View.INVISIBLE);
        edCieF2.setVisibility(View.INVISIBLE);
        edCieN3.setVisibility(View.INVISIBLE);
        edCieF3.setVisibility(View.INVISIBLE);
        edCieNF.setVisibility(View.INVISIBLE);
        edCieFF.setVisibility(View.INVISIBLE);
        edEFN1.setVisibility(View.INVISIBLE);
        edEFF1.setVisibility(View.INVISIBLE);
        edEFN2.setVisibility(View.INVISIBLE);
        edEFF2.setVisibility(View.INVISIBLE);
        edEFN3.setVisibility(View.INVISIBLE);
        edEFF3.setVisibility(View.INVISIBLE);
        edEFNF.setVisibility(View.INVISIBLE);
        edEFFF.setVisibility(View.INVISIBLE);
        edERN1.setVisibility(View.INVISIBLE);
        edERF1.setVisibility(View.INVISIBLE);
        edERN2.setVisibility(View.INVISIBLE);
        edERF2.setVisibility(View.INVISIBLE);
        edERN3.setVisibility(View.INVISIBLE);
        edERF3.setVisibility(View.INVISIBLE);
        edERNF.setVisibility(View.INVISIBLE);
        edERFF.setVisibility(View.INVISIBLE);
        edGeoN1.setVisibility(View.INVISIBLE);
        edGeoF1.setVisibility(View.INVISIBLE);
        edGeoN2.setVisibility(View.INVISIBLE);
        edGeoF2.setVisibility(View.INVISIBLE);
        edGeoN3.setVisibility(View.INVISIBLE);
        edGeoF3.setVisibility(View.INVISIBLE);
        edGeoNF.setVisibility(View.INVISIBLE);
        edGeoFF.setVisibility(View.INVISIBLE);
        edHisN1.setVisibility(View.INVISIBLE);
        edHisF1.setVisibility(View.INVISIBLE);
        edHisN2.setVisibility(View.INVISIBLE);
        edHisF2.setVisibility(View.INVISIBLE);
        edHisN3.setVisibility(View.INVISIBLE);
        edHisF3.setVisibility(View.INVISIBLE);
        edHisNF.setVisibility(View.INVISIBLE);
        edHisFF.setVisibility(View.INVISIBLE);
        edIngN1.setVisibility(View.INVISIBLE);
        edIngF1.setVisibility(View.INVISIBLE);
        edIngN2.setVisibility(View.INVISIBLE);
        edIngF2.setVisibility(View.INVISIBLE);
        edIngN3.setVisibility(View.INVISIBLE);
        edIngF3.setVisibility(View.INVISIBLE);
        edIngNF.setVisibility(View.INVISIBLE);
        edIngFF.setVisibility(View.INVISIBLE);
        edMatN1.setVisibility(View.INVISIBLE);
        edMatF1.setVisibility(View.INVISIBLE);
        edMatN2.setVisibility(View.INVISIBLE);
        edMatF2.setVisibility(View.INVISIBLE);
        edMatN3.setVisibility(View.INVISIBLE);
        edMatF3.setVisibility(View.INVISIBLE);
        edMatNF.setVisibility(View.INVISIBLE);
        edMatFF.setVisibility(View.INVISIBLE);
        edPorN1.setVisibility(View.INVISIBLE);
        edPorF1.setVisibility(View.INVISIBLE);
        edPorN2.setVisibility(View.INVISIBLE);
        edPorF2.setVisibility(View.INVISIBLE);
        edPorN3.setVisibility(View.INVISIBLE);
        edPorF3.setVisibility(View.INVISIBLE);
        edPorNF.setVisibility(View.INVISIBLE);
        edPorFF.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btm_desempenho:
                exibeDesempenho();
                break;
            case R.id.btm_horario:
                exibeHorario();
                break;
            case R.id.bte_buscar:
                resetaTela();
                break;
            default:
                break;
        }
    }

    private void pegaTurma() {
        banco = FirebaseFirestore.getInstance();
        DocumentReference aluno = banco.collection("user").document(email);
        aluno.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Usuario usuario = documentSnapshot.toObject(Usuario.class);
                if (usuario != null) {
                    turma = usuario.getTurma();
                }
            }
        });
    }

    private void resetaTela() {
        limpaTela();
        btDesempenho.setVisibility(View.VISIBLE);
        btHorario.setVisibility(View.VISIBLE);
    }

}