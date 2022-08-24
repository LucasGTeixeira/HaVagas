package br.edu.ifsp.scl.ads.pdm.havagas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import br.edu.ifsp.scl.ads.pdm.havagas.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding amb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        amb = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(amb.getRoot());
        Vagas vagas = new Vagas();

        amb.nomeCompletoEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String nomeCompleto = charSequence.toString();
                vagas.setNomeCompleto(nomeCompleto);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        amb.emailEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String email = charSequence.toString();
                vagas.setEmail(email);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        amb.receberNotificacaoCb.setOnClickListener((view -> vagas.setReceberEmail(true)));

        amb.telefoneEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String telefone = charSequence.toString();
                vagas.setTelefone(telefone);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        if(amb.fixoRb.isChecked())
            vagas.setTipoTel("fixo");
        else{
            vagas.setTipoTel("comercial");
        }

        amb.adicionarTelefoneCb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vagas.setPossuiCel(true);
                amb.telefoneCelularEt.setVisibility(View.VISIBLE);
            }
        });

        if(amb.masculinoRg.isChecked())
            vagas.setSexo("masculono");
        else{
            vagas.setSexo("feminino");
        }

        amb.dataNascimentoEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String dataNascimento = charSequence.toString();
                vagas.setDate(dataNascimento);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        amb.FormacaoSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Formacoes formacao = Formacoes.values()[i];
                vagas.setFormacao(formacao);
                if(formacao.equals(Formacoes.EnsinoMedio))
                    amb.anoFormacaoEt.setVisibility(View.VISIBLE);
                else if(formacao.equals(Formacoes.EnsinoFundamental))
                    amb.anoDeConclusaoEt.setVisibility(View.VISIBLE);
                else if(formacao.equals(Formacoes.Graducao))
                    amb.instituicaoEt.setVisibility(View.VISIBLE);
                else if(formacao.equals(Formacoes.Mestrado) || formacao.equals(Formacoes.Doutorado)) {
                    amb.tituloEt.setVisibility(View.VISIBLE);
                    amb.orientadorEt.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        amb.anoFormacaoEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String anoFormacao = charSequence.toString();
                vagas.setAnoFormacao(anoFormacao);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        amb.anoDeConclusaoEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String anoConlusao = charSequence.toString();
                vagas.setAnoConclusao(anoConlusao);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        amb.instituicaoEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String instituicao = charSequence.toString();
                vagas.setInstituicao(instituicao);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        amb.tituloEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String titulo = charSequence.toString();
                vagas.setTitulo(titulo);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        amb.orientadorEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String orientador = charSequence.toString();
                vagas.setOrientador(orientador);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        amb.vagasDeInteresse.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String vagasInteresse = charSequence.toString();
                vagas.setVagasInteresse(vagasInteresse);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        amb.limparBt.setOnClickListener(view -> {
            amb.emailEt.setText("");
            amb.receberNotificacaoCb.setChecked(false);
            amb.telefoneEt.setText("");
            amb.comerciarlRb.setChecked(false);
            amb.fixoRb.setChecked(false);
            amb.adicionarTelefoneCb.setChecked(false);
            amb.telefoneCelularEt.setText("");
            amb.masculinoRg.setChecked(false);
            amb.femininoRg.setChecked(false);
            amb.dataNascimentoEt.setText("");
            amb.anoFormacaoEt.setText("");
            amb.anoDeConclusaoEt.setText("");
            amb.instituicaoEt.setText("");
            amb.tituloEt.setText("");
            amb.orientadorEt.setText("");
            amb.vagasDeInteresse.setText("");
        });

        amb.salvarBt.setOnClickListener(view -> {
            String vaga  = vagas.toString();
            Toast.makeText(this, vaga, Toast.LENGTH_SHORT).show();
        });


    }
}