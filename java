package com.example.trabalhodificil;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText nome, email, idade, materia, nota, nota2;
private Button button, button2;
private TextView resultado;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.editTextnome);
        email = findViewById(R.id.email);
        idade = findViewById(R.id.idade);
        materia = findViewById(R.id.materia);
        nota = findViewById(R.id.nota);
        nota2 = findViewById(R.id.nota2);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        resultado = findViewById(R.id.resultado);


button.setOnClickListener(new View.OnClickListener() {

    @Override

    public void onClick(View view) {




        boolean checar_nome;
        if (!nome.getText().toString().isEmpty()){
            checar_nome = true;
        }
        else{
            checar_nome = false;
            resultado.setText("O nome precisa ser preenchido!");
        }

        boolean checar_email;
        if (!email.getText().toString().isEmpty() && email.getText().toString().contains("@") && email.getText().toString().indexOf("@") > 5){
            checar_email = true;
        }
        else {
            checar_email = false;
        resultado.setText("O campo de email deve conter um endereço de email válido!");
        }

        boolean checar_idade;
        if (!idade.getText().toString().isEmpty() && idade2(idade.getText().toString()) && Integer.parseInt(idade.getText().toString()) >= 0){
            checar_idade = true;
        }
        else{
            checar_idade = false;
            resultado.setText("O campo de idade deve ser numérico e positivo!");
        }

        boolean checar_materia;
        if (!materia.getText().toString().isEmpty()){
            checar_materia = true;
        }
        else {
            checar_materia = false;
            resultado.setText("O campo disciplina precisa ser preenchido!");
        }

        boolean checar_nota;
        if (!nota.getText().toString().isEmpty() && idade2(nota.getText().toString()) && Double.parseDouble(nota.getText().toString()) >= 0 && Double.parseDouble(nota.getText().toString()) <= 10 && !nota2.getText().toString().isEmpty() && idade2(nota2.getText().toString()) && Double.parseDouble(nota2.getText().toString()) >= 0 && Double.parseDouble(nota2.getText().toString()) <= 10  ){

            checar_nota = true;
        }
        else {
            checar_nota = false;
resultado.setText("O campo de notas deve conter um valor entre 0 e 10!");
        }

if (checar_nome && checar_email && checar_idade && checar_materia && checar_nota) {
    double media = Double.parseDouble(nota.getText().toString());
    double media2 = Double.parseDouble(nota2.getText().toString());

    double resul = (media + media2) / 2;

    String armazena;
    if (resul >= 6){
    armazena = "Aprovado!";
}
    else{
        armazena = "Reprovado!";
    }
    String nome1 = "Nome: " + nome.getText().toString();
    String email1 = "Email: " + email.getText().toString();
    String idade1 = "Idade: " + idade.getText().toString();
    String materia1 = "Disciplina: " + materia.getText().toString();
    String nota1 = "Primeira Nota: " + nota.getText().toString();
    String nota4 = "Segunda Nota: " + nota2.getText().toString();
    String resul2 = "Resultado da média: " + resul;
    String situacao = armazena;

    resultado.setText(nome1 + "\n" + email1 + "\n" + idade1 + "\n" + materia1 + "\n" + nota1 + "\n" + nota4 + "\n" + resul2 + "\n" + situacao);
}


        }

});
button2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      nome.setText("");
        email.setText("");
        idade.setText("");
        materia.setText("");
        nota.setText("");
        nota2.setText("");
        resultado.setText("");
    }
});











        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
public boolean idade2(String idade2){
    return idade2.matches("\\d+");

}





}
