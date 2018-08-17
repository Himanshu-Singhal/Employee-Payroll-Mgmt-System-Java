package com.example.singh.payrolldec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.invoke.MethodType;

public class MainActivity extends AppCompatActivity
{
    EditText etName, etAge, etSalary, etBonus, etRate, etNOH, etCom, etFix, etSchool, etMake, etModel, etCC ;
    String CarType = "" ;
    Boolean isSportsBike = false;
    Car car;
    Motorcycle motorcycle;
    String EmpType = "";
    String PartTimeType = "";
    String VehicleType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etSalary = (EditText) findViewById(R.id.etSalary);
        etBonus = (EditText) findViewById(R.id.etBonus);
        etRate = (EditText) findViewById(R.id.etRate);
        etNOH = (EditText) findViewById(R.id.etNOH);
        etCom = (EditText) findViewById(R.id.etCom);
        etFix = (EditText) findViewById(R.id.etFix);
        etSchool = (EditText) findViewById(R.id.etSchool);
        etMake = (EditText) findViewById(R.id.etMake);
        etModel = (EditText) findViewById(R.id.etModel);
        etCC = (EditText) findViewById(R.id.etCC);
        Spinner empType = (Spinner) findViewById(R.id.empType);
        Spinner PTtype = (Spinner) findViewById(R.id.PTtype);
        Spinner VType = (Spinner) findViewById(R.id.VType);
        Spinner Mtype = (Spinner) findViewById(R.id.MType);
        Spinner Ctype = (Spinner) findViewById(R.id.CType);
        Button btnSubmit   = (Button)findViewById(R.id.btnSubmit);
        TextView console = (TextView)findViewById(R.id.Console);
        console.setText("Output Here !!!");

        Ctype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {


                CarType = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        empType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                if(parent.getSelectedItem().toString().equals("Part Time"))
                {
                    etBonus.setEnabled(false);
                    etBonus.clearFocus();
                    etSalary.setEnabled(false);
                    etFix.setEnabled(true);
                    etNOH.setEnabled(true);
                    etCom.setEnabled(true);
                    etRate.setEnabled(true);
                    etSchool.setEnabled(false);
                    EmpType = "Part Time";
                    PTtype.setEnabled(true);

                }
                if(parent.getSelectedItem().toString().equals("Full Time"))
                {
                    etBonus.setEnabled(true);
                    etSchool.setEnabled(false);

                    etSalary.setEnabled(true);
                    etFix.setEnabled(false);
                    etNOH.setEnabled(false);
                    etCom.setEnabled(false);
                    etRate.setEnabled(false);
                    EmpType = "Full Time";
                    PTtype.setEnabled(false);

                }
                if(parent.getSelectedItem().toString().equals("Intern"))
                {
                    etSchool.setEnabled(true);
                    etBonus.setEnabled(false);
                    etSalary.setEnabled(false);
                    etFix.setEnabled(false);
                    etNOH.setEnabled(false);
                    etCom.setEnabled(false);
                    etRate.setEnabled(false);
                    EmpType = "Intern";
                    PTtype.setEnabled(false);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        PTtype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if(parent.getSelectedItem().toString().equals("Commission Based"))
                {
                    etFix.setEnabled(false);
                    etNOH.setEnabled(true);
                    etCom.setEnabled(true);
                    etRate.setEnabled(true);
                    PartTimeType = "Commission Based";

                }
                if(parent.getSelectedItem().toString().equals("Fixed Based"))
                {
                    etFix.setEnabled(true);
                    etNOH.setEnabled(true);
                    etCom.setEnabled(false);
                    etRate.setEnabled(true);
                    PartTimeType = "Fixed Based";

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Mtype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if(parent.getSelectedItem().toString().equals("Yes"))
                {
                    isSportsBike = true;

                }
                else  if(parent.getSelectedItem().toString().equals("No"))
                {
                    isSportsBike = false;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        VType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if(parent.getSelectedItem().toString().equals("Car"))
                {
                    Mtype.setEnabled(false);
                    Ctype.setEnabled(true);
                    VehicleType = "Car";
                    Mtype.setEnabled(false);
                    Ctype.setEnabled(true);


                }
                if(parent.getSelectedItem().toString().equals("Motorcycle"))
                {
                    Ctype.setEnabled(false);
                    Mtype.setEnabled(true);
                    VehicleType = "Motorcycle";
                    Ctype.setEnabled(false);
                    Mtype.setEnabled(true);

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(VehicleType.equals("Car"))
                {
                    car = new Car(etMake.getText().toString(), etModel.getText().toString(), Double.parseDouble(etCC.getText().toString()), CarType);
                    ProjectSingleton.getProjectSingletonInstance().addVehicle(car);

                    if(EmpType.equals("Full Time"))
                    {
                        FullTime fullTime = new FullTime( etName.getText().toString(), Integer.parseInt(etCC.getText().toString()), car, Integer.parseInt(etSalary.getText().toString()) , Integer.parseInt(etBonus.getText().toString()));
                        ProjectSingleton.getProjectSingletonInstance().addEmployee(fullTime);
                    }
                    else if(EmpType.equals("Intern"))
                    {
                        Intern intern = new Intern( etName.getText().toString(), Integer.parseInt(etAge.getText().toString()), car, etSchool.getText().toString());
                        ProjectSingleton.getProjectSingletonInstance().addEmployee(intern);
                        Toast.makeText(MainActivity.this, "Employee Detail Submitted", Toast.LENGTH_SHORT).show();

                        Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                    }
                    else if(EmpType.equals("Part Time"))
                    {
                        if(PartTimeType.equals("Commission Based"))
                        {
                            CommissionBasedPartTime commissionBasedPartTime = new CommissionBasedPartTime(Integer.parseInt(etCom.getText().toString()),  etName.getText().toString(), Integer.parseInt(etAge.getText().toString()), car, Integer.parseInt(etRate.getText().toString()), Integer.parseInt(etNOH.getText().toString()));
                            ProjectSingleton.getProjectSingletonInstance().addEmployee(commissionBasedPartTime);
                        }
                        else if(PartTimeType.equals("Fixed Based"))
                        {
                            FixedBasedPartTime fixedBasedPartTime = new FixedBasedPartTime( etName.getText().toString(), Integer.parseInt(etAge.getText().toString()), car, Integer.parseInt(etRate.getText().toString()), Integer.parseInt(etNOH.getText().toString()), Integer.parseInt(etFix.getText().toString()));
                            ProjectSingleton.getProjectSingletonInstance().addEmployee(fixedBasedPartTime);
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Invalid Part Time Type", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Invalid Employee Type", Toast.LENGTH_SHORT).show();
                    }
                    ProjectSingleton.getProjectSingletonInstance().displayAllEmployeeDetails();
                    console.setText(ProjectSingleton.getProjectSingletonInstance().displayAllEmployeeDetails());

                }
                else if(VehicleType.equals("Motorcycle"))
                {
                    motorcycle = new Motorcycle( etMake.getText().toString(), etModel.getText().toString(),  Double.parseDouble(etCC.getText().toString()) , isSportsBike);
                    ProjectSingleton.getProjectSingletonInstance().addVehicle(motorcycle);

                    if(EmpType.equals("Full Time"))
                    {
                        FullTime fullTime = new FullTime( etName.getText().toString(), Integer.parseInt(etCC.getText().toString()), motorcycle, Integer.parseInt(etSalary.getText().toString()) , Integer.parseInt(etBonus.getText().toString()));
                        ProjectSingleton.getProjectSingletonInstance().addEmployee(fullTime);
                    }
                    else if(EmpType.equals("Intern"))
                    {
                        Intern intern = new Intern( etName.getText().toString(), Integer.parseInt(etAge.getText().toString()), motorcycle, etSchool.getText().toString());
                        ProjectSingleton.getProjectSingletonInstance().addEmployee(intern);
                        Toast.makeText(MainActivity.this, "Employee Detail Submitted", Toast.LENGTH_SHORT).show();

                        Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                    }
                    else if(EmpType.equals("Part Time"))
                    {
                        if(PartTimeType.equals("Commission Based"))
                        {
                            CommissionBasedPartTime commissionBasedPartTime = new CommissionBasedPartTime(Integer.parseInt(etCom.getText().toString()),  etName.getText().toString(), Integer.parseInt(etAge.getText().toString()), motorcycle, Integer.parseInt(etRate.getText().toString()), Integer.parseInt(etNOH.getText().toString()));
                            ProjectSingleton.getProjectSingletonInstance().addEmployee(commissionBasedPartTime);
                        }
                        else if(PartTimeType.equals("Fixed Based"))
                        {
                            FixedBasedPartTime fixedBasedPartTime = new FixedBasedPartTime( etName.getText().toString(), Integer.parseInt(etAge.getText().toString()), motorcycle, Integer.parseInt(etRate.getText().toString()), Integer.parseInt(etNOH.getText().toString()), Integer.parseInt(etFix.getText().toString()));
                            ProjectSingleton.getProjectSingletonInstance().addEmployee(fixedBasedPartTime);
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Invalid Part Time Type", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Invalid Employee Type", Toast.LENGTH_SHORT).show();
                    }
                    ProjectSingleton.getProjectSingletonInstance().displayAllEmployeeDetails();
                    console.setText(ProjectSingleton.getProjectSingletonInstance().displayAllEmployeeDetails());


                }
                else
                {
                    if(EmpType.equals("Full Time"))
                    {
                        FullTime fullTime = new FullTime( etName.getText().toString(), Integer.parseInt(etCC.getText().toString()), null, Integer.parseInt(etSalary.getText().toString()) , Integer.parseInt(etBonus.getText().toString()));
                        ProjectSingleton.getProjectSingletonInstance().addEmployee(fullTime);
                    }
                    else if(EmpType.equals("Intern"))
                    {
                        Intern intern = new Intern( etName.getText().toString(), Integer.parseInt(etAge.getText().toString()), null, etSchool.getText().toString());
                        ProjectSingleton.getProjectSingletonInstance().addEmployee(intern);
                        Toast.makeText(MainActivity.this, "Employee Detail Submitted", Toast.LENGTH_SHORT).show();

                        Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                    }
                    else if(EmpType.equals("Part Time"))
                    {
                        if(PartTimeType.equals("Commission Based"))
                        {
                            CommissionBasedPartTime commissionBasedPartTime = new CommissionBasedPartTime(Integer.parseInt(etCom.getText().toString()),  etName.getText().toString(), Integer.parseInt(etAge.getText().toString()), null, Integer.parseInt(etRate.getText().toString()), Integer.parseInt(etNOH.getText().toString()));
                            ProjectSingleton.getProjectSingletonInstance().addEmployee(commissionBasedPartTime);
                        }
                        else if(PartTimeType.equals("Fixed Based"))
                        {
                            FixedBasedPartTime fixedBasedPartTime = new FixedBasedPartTime( etName.getText().toString(), Integer.parseInt(etAge.getText().toString()), null, Integer.parseInt(etRate.getText().toString()), Integer.parseInt(etNOH.getText().toString()), Integer.parseInt(etFix.getText().toString()));
                            ProjectSingleton.getProjectSingletonInstance().addEmployee(fixedBasedPartTime);
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Invalid Part Time Type", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Invalid Employee Type", Toast.LENGTH_SHORT).show();
                    }
                    ProjectSingleton.getProjectSingletonInstance().displayAllEmployeeDetails();
                    console.setText(ProjectSingleton.getProjectSingletonInstance().displayAllEmployeeDetails());
                }


            }
        });
    }
}
