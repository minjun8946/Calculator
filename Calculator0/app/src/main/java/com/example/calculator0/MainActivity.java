package com.example.calculator0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int num = 0; //실제 숫자 값
    int pm = 0; // 부호를 확인시키는 값
    int result = 0; // 기억하는 것으로 넘어가는 값
    int i = 0; // 첫번째 숫자인지 확인하는 변수
    int pre=0; // 부호를 입력한 후 값을 기억하는 수
    int j=0;//부호다음의 첫번째 자릿수 확인
    int number=0; // 첫번째 계산인지 확인하는 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView memory = (TextView)findViewById(R.id.memory); // 텍스트 뷰 이전값 기억
        final TextView push = (TextView)findViewById(R.id.push); // 텍스트 뷰 현재 누르는 것


        Button back = (Button)findViewById(R.id.back); //첫번쨰 줄 뒤로가기
        Button remainder = (Button)findViewById(R.id.remainder); //첫번쨰 줄 나머지
        Button initialization = (Button)findViewById(R.id.initialization); //첫번쨰 줄 초기화
        Button division = (Button)findViewById(R.id.division); //첫번쨰 줄 나누기


        Button seven = (Button)findViewById(R.id.seven);//두번째 줄 7
        Button eight = (Button)findViewById(R.id.eight); //두번째 줄 8
        Button nine = (Button)findViewById(R.id.nine); //두번째 줄 9
        Button multiply = (Button)findViewById(R.id.multiply);//두번째 줄 곱하기

        Button four = (Button)findViewById(R.id.four); // 세번째 줄 4
        Button five = (Button)findViewById(R.id.five); // 세번째 줄 5
        Button six = (Button)findViewById(R.id.six); // 세번째 줄 6
        Button minus = (Button)findViewById(R.id.minus); // 세번째 줄 뺴기

        Button one = (Button)findViewById(R.id.one); // 네번째 줄 1
        Button two = (Button)findViewById(R.id.two); // 네번째 줄 2
        Button three = (Button)findViewById(R.id.three); // 네번째 줄 3
        Button plus = (Button)findViewById(R.id.plus); // 네번째 줄 더히기

        Button sign = (Button)findViewById(R.id.sign); // 다섯번쨰 줄 부호
        Button zero = (Button)findViewById(R.id.zero); // 다섯번쨰 줄 0
        Button squ = (Button)findViewById(R.id.squ); // 다섯번쨰 줄 제곱
        Button equal = (Button)findViewById(R.id.equal); // 다섯번쨰 줄 계산 결과

        back.setOnClickListener(new View.OnClickListener() { //첫번쨰 줄 뒤로가기
            @Override
            public void onClick(View view) {
                if(pm==0 && number==0) {
                    num /= 10;
                    push.setText(Integer.toString(num));
                }
                else if(pm==1 && number==0) {
                    num /= 10;
                    push.setText(Integer.toString(pre)+"+"+num);
                }
                else if(pm==2 && number==0) {
                    num /= 10;
                    push.setText(Integer.toString(pre)+"-"+num);
                }
                else if(pm==3 && number==0) {
                    num /= 10;
                    push.setText(Integer.toString(pre)+"*"+num);
                }
                else if(pm==4 && number==0) {
                    num /= 10;
                    push.setText(Integer.toString(pre)+"÷"+num);
                }
                else if(pm==5 && number==0) {
                    num /= 10;
                    push.setText(Integer.toString(pre)+"%"+num);
                }

                else if(pm==1 && number==1){
                    num /= 10;
                    push.setText(Integer.toString(pre)+"+"+num);

                }
                else if(pm==2 && number==1){
                    num /= 10;
                    push.setText(Integer.toString(pre)+"-"+num);
                }
                else if(pm==3 && number==1){
                    num /= 10;
                    push.setText(Integer.toString(pre)+"*"+num);
                }
                else if(pm==4 && number==1){
                    num /= 10;
                    push.setText(Integer.toString(pre)+"÷"+num);
                }
                else if(pm==5 && number==1){
                    num /= 10;
                    push.setText(Integer.toString(pre)+"%"+num);
                }
            }
        });

        remainder.setOnClickListener(new View.OnClickListener() { //첫번쨰 줄 나머지
            @Override
            public void onClick(View view) {
                if(num==0&&result!=0){
                    pm=5;
                    num=0;
                    push.setText(Integer.toString(pre)+"%");
                }
                else if(num!=0&&result==0 && pm==0){
                    pm=5;
                    pre=num;
                    num=0;
                    push.setText(Integer.toString(pre)+"%");
                }
            }
        });

        initialization.setOnClickListener(new View.OnClickListener() { //첫번쨰 줄 초기화
            @Override
            public void onClick(View view) {
                num = 0;
                pm = 0;
                result = 0;
                i = 0;
                pre=0;
                j=0;
                number=0;

                memory.setText(" ");
                push.setText("0");;
            }
        });

        division.setOnClickListener(new View.OnClickListener() { //첫번쨰 줄 나누기
            @Override
            public void onClick(View view) {
                if(num==0&&result!=0){
                    pm=4;
                    num=0;
                    push.setText(Integer.toString(pre)+"÷");
                }
                else if(num!=0&&result==0 && pm==0){
                    pm=4;
                    pre=num;
                    num=0;
                    push.setText(Integer.toString(pre)+"÷");
                }
            }
        });




        seven.setOnClickListener(new View.OnClickListener() { //두번쨰 줄 7
            @Override
            public void onClick(View view) {
                if (pm == 0) {

                    if (i == 0) {
                        num += 7;
                        push.setText(Integer.toString(num));
                        i++;
                    } else {
                        num = num * 10 + 7;
                        push.setText(Integer.toString(num));

                    }
                }
                else if(pm==1){
                    if (i == 0) {
                        num += 7;
                        push.setText(Integer.toString(pre)+"+"+num);
                        i++;
                    } else {
                        num = num * 10 + 7;
                        push.setText(Integer.toString(pre)+"+"+num);

                    }
                }
                else if(pm==2){
                    if (i == 0) {
                        num += 7;
                        push.setText(Integer.toString(pre)+"-"+num);
                        i++;
                    } else {
                        num = num * 10 + 7;
                        push.setText(Integer.toString(pre)+"-"+num);

                    }
                }
                else if(pm==3){
                    if (i == 0) {
                        num += 7;
                        push.setText(Integer.toString(pre)+"*"+num);
                        i++;
                    } else {
                        num = num * 10 + 7;
                        push.setText(Integer.toString(pre)+"*"+num);

                    }
                }
                else if(pm==4){
                    if (i == 0) {
                        num += 7;
                        push.setText(Integer.toString(pre)+"÷"+num);
                        i++;
                    } else {
                        num = num * 10 + 7;
                        push.setText(Integer.toString(pre)+"÷"+num);

                    }
                }
                else if(pm==5){
                    if (i == 0) {
                        num += 7;
                        push.setText(Integer.toString(pre)+"%"+num);
                        i++;
                    } else {
                        num = num * 10 + 7;
                        push.setText(Integer.toString(pre)+"%"+num);

                    }
                }
            }
        });

        eight.setOnClickListener(new View.OnClickListener() { //두번쨰 줄 8
            @Override
            public void onClick(View view) {
                if (pm == 0) {

                    if (i == 0) {
                        num += 8;
                        push.setText(Integer.toString(num));
                        i++;
                    } else {
                        num = num * 10 + 8;
                        push.setText(Integer.toString(num));

                    }
                }
                else if(pm==1){
                    if (i == 0) {
                        num += 8;
                        push.setText(Integer.toString(pre)+"+"+num);
                        i++;
                    } else {
                        num = num * 10 + 8;
                        push.setText(Integer.toString(pre)+"+"+num);

                    }
                }
                else if(pm==2){
                    if (i == 0) {
                        num += 8;
                        push.setText(Integer.toString(pre)+"-"+num);
                        i++;
                    } else {
                        num = num * 10 + 8;
                        push.setText(Integer.toString(pre)+"-"+num);

                    }
                }
                else if(pm==3){
                    if (i == 0) {
                        num += 8;
                        push.setText(Integer.toString(pre)+"*"+num);
                        i++;
                    } else {
                        num = num * 10 + 8;
                        push.setText(Integer.toString(pre)+"*"+num);

                    }
                }
                else if(pm==4){
                    if (i == 0) {
                        num += 8;
                        push.setText(Integer.toString(pre)+"÷"+num);
                        i++;
                    } else {
                        num = num * 10 + 8;
                        push.setText(Integer.toString(pre)+"÷"+num);

                    }
                }
                else if(pm==5){
                    if (i == 0) {
                        num += 8;
                        push.setText(Integer.toString(pre)+"%"+num);
                        i++;
                    } else {
                        num = num * 10 + 8;
                        push.setText(Integer.toString(pre)+"%"+num);

                    }
                }
            }
        });

        nine.setOnClickListener(new View.OnClickListener() { //두번쨰 줄 9
            @Override
            public void onClick(View view) {
                if (pm == 0) {

                    if (i == 0) {
                        num += 9;
                        push.setText(Integer.toString(num));
                        i++;
                    } else {
                        num = num * 10 + 9;
                        push.setText(Integer.toString(num));

                    }
                }
                else if(pm==1){
                    if (i == 0) {
                        num += 9;
                        push.setText(Integer.toString(pre)+"+"+num);
                        i++;
                    } else {
                        num = num * 10 + 9;
                        push.setText(Integer.toString(pre)+"+"+num);

                    }
                }
                else if(pm==2){
                    if (i == 0) {
                        num += 9;
                        push.setText(Integer.toString(pre)+"-"+num);
                        i++;
                    } else {
                        num = num * 10 + 9;
                        push.setText(Integer.toString(pre)+"-"+num);

                    }
                }
                else if(pm==3){
                    if (i == 0) {
                        num += 9;
                        push.setText(Integer.toString(pre)+"*"+num);
                        i++;
                    } else {
                        num = num * 10 + 9;
                        push.setText(Integer.toString(pre)+"*"+num);

                    }
                }
                else if(pm==4){
                    if (i == 0) {
                        num += 9;
                        push.setText(Integer.toString(pre)+"÷"+num);
                        i++;
                    } else {
                        num = num * 10 + 9;
                        push.setText(Integer.toString(pre)+"÷"+num);

                    }
                }
                else if(pm==5){
                    if (i == 0) {
                        num += 9;
                        push.setText(Integer.toString(pre)+"%"+num);
                        i++;
                    } else {
                        num = num * 10 + 9;
                        push.setText(Integer.toString(pre)+"%"+num);

                    }
                }
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() { //두번쨰 줄 곱하기
            @Override
            public void onClick(View view) {
                if(num==0&&result!=0){
                    pm=3;
                    num=0;
                    push.setText(Integer.toString(pre)+"*");
                }
                else if(num!=0&&result==0 && pm==0){
                    pm=3;
                    pre=num;
                    num=0;
                    push.setText(Integer.toString(pre)+"*");
                }
            }
        });



        four.setOnClickListener(new View.OnClickListener() { //세번쨰 줄 4
            @Override
            public void onClick(View view) {
                if (pm == 0) {

                    if (i == 0) {
                        num += 4;
                        push.setText(Integer.toString(num));
                        i++;
                    } else {
                        num = num * 10 + 4;
                        push.setText(Integer.toString(num));

                    }
                }
                else if(pm==1){
                    if (i == 0) {
                        num += 4;
                        push.setText(Integer.toString(pre)+"+"+num);
                        i++;
                    } else {
                        num = num * 10 + 4;
                        push.setText(Integer.toString(pre)+"+"+num);

                    }
                }
                else if(pm==2){
                    if (i == 0) {
                        num += 4;
                        push.setText(Integer.toString(pre)+"-"+num);
                        i++;
                    } else {
                        num = num * 10 + 4;
                        push.setText(Integer.toString(pre)+"-"+num);

                    }
                }
                else if(pm==3){
                    if (i == 0) {
                        num += 4;
                        push.setText(Integer.toString(pre)+"*"+num);
                        i++;
                    } else {
                        num = num * 10 + 4;
                        push.setText(Integer.toString(pre)+"*"+num);

                    }
                }
                else if(pm==4){
                    if (i == 0) {
                        num += 4;
                        push.setText(Integer.toString(pre)+"÷"+num);
                        i++;
                    } else {
                        num = num * 10 + 4;
                        push.setText(Integer.toString(pre)+"÷"+num);

                    }
                }
                else if(pm==5){
                    if (i == 0) {
                        num += 4;
                        push.setText(Integer.toString(pre)+"%"+num);
                        i++;
                    } else {
                        num = num * 10 + 4;
                        push.setText(Integer.toString(pre)+"%"+num);

                    }
                }
            }
        });

        five.setOnClickListener(
                new View.OnClickListener() { //세번쨰 줄 5
            @Override
            public void onClick(View view) {
                if (pm == 0) {

                    if (i == 0) {
                        num += 5;
                        push.setText(Integer.toString(num));
                        i++;
                    } else {
                        num = num * 10 + 5;
                        push.setText(Integer.toString(num));

                    }
                }
                else if(pm==1){
                    if (i == 0) {
                        num += 5;
                        push.setText(Integer.toString(pre)+"+"+num);
                        i++;
                    } else {
                        num = num * 10 + 5;
                        push.setText(Integer.toString(pre)+"+"+num);

                    }
                }
                else if(pm==2){
                    if (i == 0) {
                        num += 5;
                        push.setText(Integer.toString(pre)+"-"+num);
                        i++;
                    } else {
                        num = num * 10 + 5;
                        push.setText(Integer.toString(pre)+"-"+num);

                    }
                }
                else if(pm==3){
                    if (i == 0) {
                        num += 5;
                        push.setText(Integer.toString(pre)+"*"+num);
                        i++;
                    } else {
                        num = num * 10 + 5;
                        push.setText(Integer.toString(pre)+"*"+num);

                    }
                }
                else if(pm==4){
                    if (i == 0) {
                        num += 5;
                        push.setText(Integer.toString(pre)+"÷"+num);
                        i++;
                    } else {
                        num = num * 10 + 5;
                        push.setText(Integer.toString(pre)+"÷"+num);

                    }
                }
                else if(pm==5){
                    if (i == 0) {
                        num += 5;
                        push.setText(Integer.toString(pre)+"%"+num);
                        i++;
                    } else {
                        num = num * 10 + 5;
                        push.setText(Integer.toString(pre)+"%"+num);

                    }
                }
            }
        });

        six.setOnClickListener(new View.OnClickListener() { //세번쨰 줄 6
            @Override
            public void onClick(View view) {
                if (pm == 0) {

                    if (i == 0) {
                        num += 6;
                        push.setText(Integer.toString(num));
                        i++;
                    } else {
                        num = num * 10 + 6;
                        push.setText(Integer.toString(num));

                    }
                }
                else if(pm==1){
                    if (i == 0) {
                        num += 6;
                        push.setText(Integer.toString(pre)+"+"+num);
                        i++;
                    } else {
                        num = num * 10 + 6;
                        push.setText(Integer.toString(pre)+"+"+num);

                    }
                }
                else if(pm==2){
                    if (i == 0) {
                        num += 6;
                        push.setText(Integer.toString(pre)+"-"+num);
                        i++;
                    } else {
                        num = num * 10 + 6;
                        push.setText(Integer.toString(pre)+"-"+num);

                    }
                }
                else if(pm==3){
                    if (i == 0) {
                        num += 6;
                        push.setText(Integer.toString(pre)+"*"+num);
                        i++;
                    } else {
                        num = num * 10 + 6;
                        push.setText(Integer.toString(pre)+"*"+num);

                    }
                }
                else if(pm==4){
                    if (i == 0) {
                        num += 6;
                        push.setText(Integer.toString(pre)+"÷"+num);
                        i++;
                    } else {
                        num = num * 10 + 6;
                        push.setText(Integer.toString(pre)+"÷"+num);

                    }
                }
                else if(pm==5){
                    if (i == 0) {
                        num += 6;
                        push.setText(Integer.toString(pre)+"%"+num);
                        i++;
                    } else {
                        num = num * 10 + 6;
                        push.setText(Integer.toString(pre)+"%"+num);

                    }
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() { //세번쨰 줄 빼기
            @Override
            public void onClick(View view) {
                if(num==0&&result!=0){
                    pm=2;
                    num=0;
                    push.setText(Integer.toString(pre)+"-");
                }
                else if(num!=0&&result==0 && pm==0){
                    pm=2;
                    pre=num;
                    num=0;
                    push.setText(Integer.toString(pre)+"-");
                }
            }
        });




        one.setOnClickListener(new View.OnClickListener() { //네번쨰 줄 1
            @Override
            public void onClick(View view) {
                if (pm == 0) {

                    if (i == 0) {
                        num += 1;
                        push.setText(Integer.toString(num));
                        i++;
                    } else {
                        num = num * 10 + 1;
                        push.setText(Integer.toString(num));

                    }
                }
                else if(pm==1){
                    if (i == 0) {
                        num += 1;
                        push.setText(Integer.toString(pre)+"+"+num);
                        i++;
                    } else {
                        num = num * 10 + 1;
                        push.setText(Integer.toString(pre)+"+"+num);

                    }
                }
                else if(pm==2){
                    if (i == 0) {
                        num += 1;
                        push.setText(Integer.toString(pre)+"-"+num);
                        i++;
                    } else {
                        num = num * 10 + 1;
                        push.setText(Integer.toString(pre)+"-"+num);

                    }
                }
                else if(pm==3){
                    if (i == 0) {
                        num += 1;
                        push.setText(Integer.toString(pre)+"*"+num);
                        i++;
                    } else {
                        num = num * 10 + 1;
                        push.setText(Integer.toString(pre)+"*"+num);

                    }
                }
                else if(pm==4){
                    if (i == 0) {
                        num += 1;
                        push.setText(Integer.toString(pre)+"÷"+num);
                        i++;
                    } else {
                        num = num * 10 + 1;
                        push.setText(Integer.toString(pre)+"÷"+num);

                    }
                }
                else if(pm==5){
                    if (i == 0) {
                        num += 1;
                        push.setText(Integer.toString(pre)+"%"+num);
                        i++;
                    } else {
                        num = num * 10 + 1;
                        push.setText(Integer.toString(pre)+"%"+num);

                    }
                }
            }
        });

        two.setOnClickListener(new View.OnClickListener() { //네번쨰 줄 2
            @Override
            public void onClick(View view) {
                if (pm == 0) {

                    if (i == 0) {
                        num += 2;
                        push.setText(Integer.toString(num));
                        i++;
                    } else {
                        num = num * 10 + 2;
                        push.setText(Integer.toString(num));

                    }
                }
                else if(pm==1){
                    if (i == 0) {
                        num += 2;
                        push.setText(Integer.toString(pre)+"+"+num);
                        i++;
                    } else {
                        num = num * 10 + 2;
                        push.setText(Integer.toString(pre)+"+"+num);

                    }
                }
                else if(pm==2){
                    if (i == 0) {
                        num += 2;
                        push.setText(Integer.toString(pre)+"-"+num);
                        i++;
                    } else {
                        num = num * 10 + 2;
                        push.setText(Integer.toString(pre)+"-"+num);

                    }
                }
                else if(pm==3){
                    if (i == 0) {
                        num += 2;
                        push.setText(Integer.toString(pre)+"*"+num);
                        i++;
                    } else {
                        num = num * 10 + 2;
                        push.setText(Integer.toString(pre)+"*"+num);

                    }
                }
                else if(pm==4){
                    if (i == 0) {
                        num += 2;
                        push.setText(Integer.toString(pre)+"÷"+num);
                        i++;
                    } else {
                        num = num * 10 + 2;
                        push.setText(Integer.toString(pre)+"÷"+num);

                    }
                }
                else if(pm==5){
                    if (i == 0) {
                        num += 2;
                        push.setText(Integer.toString(pre)+"%"+num);
                        i++;
                    } else {
                        num = num * 10 + 2;
                        push.setText(Integer.toString(pre)+"%"+num);

                    }
                }
            }
        });

        three.setOnClickListener(new View.OnClickListener() { //네번쨰 줄 3
            @Override
            public void onClick(View view) {
                if (pm == 0) {

                    if (i == 0) {
                        num += 3;
                        push.setText(Integer.toString(num));
                        i++;
                    } else {
                        num = num * 10 + 3;
                        push.setText(Integer.toString(num));

                    }
                }
                else if(pm==1){
                    if (i == 0) {
                        num += 3;
                        push.setText(Integer.toString(pre)+"+"+num);
                        i++;
                    } else {
                        num = num * 10 + 3;
                        push.setText(Integer.toString(pre)+"+"+num);

                    }
                }
                else if(pm==2){
                    if (i == 0) {
                        num += 3;
                        push.setText(Integer.toString(pre)+"-"+num);
                        i++;
                    } else {
                        num = num * 10 + 3;
                        push.setText(Integer.toString(pre)+"-"+num);

                    }
                }
                else if(pm==3){
                    if (i == 0) {
                        num += 3;
                        push.setText(Integer.toString(pre)+"*"+num);
                        i++;
                    } else {
                        num = num * 10 + 3;
                        push.setText(Integer.toString(pre)+"*"+num);

                    }
                }
                else if(pm==4){
                    if (i == 0) {
                        num += 3;
                        push.setText(Integer.toString(pre)+"÷"+num);
                        i++;
                    } else {
                        num = num * 10 + 3;
                        push.setText(Integer.toString(pre)+"÷"+num);

                    }
                }
                else if(pm==5){
                    if (i == 0) {
                        num += 3;
                        push.setText(Integer.toString(pre)+"%"+num);
                        i++;
                    } else {
                        num = num * 10 + 3;
                        push.setText(Integer.toString(pre)+"%"+num);

                    }
                }
            }
        });

        plus.setOnClickListener(new View.OnClickListener() { //네번쨰 줄 더하기
            @Override
            public void onClick(View view) {
                if(num==0&&result!=0){//두번째 부터
                    pm=1;
                    num=0;
                    push.setText(Integer.toString(pre)+"+");
                }
                else if(num!=0&&result==0 && pm==0){ //첫번째
                    pm=1;
                    pre=num;
                    num=0;
                    push.setText(Integer.toString(pre)+"+");
                }
            }
        });




        sign.setOnClickListener(new View.OnClickListener() { //다섯번쨰 줄 부호
            @Override
            public void onClick(View view) {
                if(pm==1||pm==2||pm==5) {
                    if (pre != 0 && num != 0) {
                        if (num > 0) {
                            num = num - num - num;
                            push.setText(Integer.toString(pre) + num);
                        } else {
                            num = num - num - num;
                            push.setText(Integer.toString(pre) + "+" + num);
                        }
                    } else if (pre == 0 && num != 0) {
                        if (num > 0) {
                            num = num - num - num;
                            push.setText(Integer.toString(num));
                        } else {
                            num = num - num - num;
                            push.setText(Integer.toString(num));
                        }
                    }
                }
                else if(pm==3){
                    if (pre != 0 && num != 0) {
                        if (num > 0) {
                            num = num - num - num;
                            push.setText(Integer.toString(pre) +"*("+ num+")");
                        } else {
                            num = num - num - num;
                            push.setText(Integer.toString(pre) +"*"+ num);
                        }
                    } else if (pre == 0 && num != 0) {
                        if (num > 0) {
                            num = num - num - num;
                            push.setText(Integer.toString(num));
                        } else {
                            num = num - num - num;
                            push.setText(Integer.toString(num));
                        }
                    }
                }
                else if(pm==4){
                    if (pre != 0 && num != 0) {
                        if (num > 0) {
                            num = num - num - num;
                            push.setText(Integer.toString(pre) +"÷("+ num+")");
                        } else {
                            num = num - num - num;
                            push.setText(Integer.toString(pre) +"÷"+ num);
                        }
                    } else if (pre == 0 && num != 0) {
                        if (num > 0) {
                            num = num - num - num;
                            push.setText(Integer.toString(num));
                        } else {
                            num = num - num - num;
                            push.setText(Integer.toString(num));
                        }
                    }
                }
            }
        });

        zero.setOnClickListener(new View.OnClickListener() { //댜섯번쨰 줄 0
            @Override
            public void onClick(View view) {
                if (pm == 0) {
                    if (i == 0) {
                        num += 0;
                        push.setText(Integer.toString(num));
                        i++;
                    } else {
                        num = num * 10;
                        push.setText(Integer.toString(num));

                    }
                }
                else if(pm==1){
                    if (i == 0) {
                        num += 0;
                        push.setText(Integer.toString(pre)+"+"+num);
                        i++;
                    } else {
                        num = num * 10 + 0;
                        push.setText(Integer.toString(pre)+"+"+num);

                    }
                }
                else if(pm==2){
                    if (i == 0) {
                        num += 0;
                        push.setText(Integer.toString(pre)+"-"+num);
                        i++;
                    } else {
                        num = num * 10 + 0;
                        push.setText(Integer.toString(pre)+"-"+num);

                    }
                }
                else if(pm==3){
                    if (i == 0) {
                        num += 0;
                        push.setText(Integer.toString(pre)+"*"+num);
                        i++;
                    } else {
                        num = num * 10 + 0;
                        push.setText(Integer.toString(pre)+"*"+num);

                    }
                }
                /*else if(pm==4){
                    if (i == 0) {
                        num += 0;
                        push.setText(Integer.toString(pre)+"÷"+num);
                        i++;
                    } else {
                        num = num * 10 + 0;
                        push.setText(Integer.toString(pre)+"÷"+num);

                    }
                }*/
                else if(pm==5){
                    if (i == 0) {
                        num += 0;
                        push.setText(Integer.toString(pre)+"%"+num);
                        i++;
                    } else {
                        num = num * 10 + 0;
                        push.setText(Integer.toString(pre)+"%"+num);

                    }
                }
            }
        });

        squ.setOnClickListener(new View.OnClickListener() { //다섯번쨰 줄 제곱
            @Override
            public void onClick(View view) {
                if(num==0||result==0) {
                    if (result == 0) {
                        result = num * num;
                        num = 0;
                        pre = 0;
                        number = 0;
                        push.setText("0");
                        memory.setText(Integer.toString(result));
                        pre = result;
                        i = 0;
                    } else {
                        result *= result;
                        num = 0;
                        pre = 0;
                        number = 1;
                        push.setText("0");
                        memory.setText(Integer.toString(result));
                        pre = result;
                        i = 0;
                    }
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() { //다섯번쨰 줄 결과
            @Override
            public void onClick(View view) {

                if(pm==1 && i!=0){
                    result=pre+num;
                    num=0;
                    number=1;
                    push.setText("0");
                    memory.setText(Integer.toString(result));
                    pre = result;
                    i=0;
                }
                if(pm==2 && i!=0){
                    result=pre-num;
                    num=0;
                    number=1;
                    push.setText("0");
                    memory.setText(Integer.toString(result));
                    pre = result;
                    i=0;
                }
                if(pm==3 && i!=0){
                    result=pre*num;
                    num=0;
                    number=1;
                    push.setText("0");
                    memory.setText(Integer.toString(result));
                    pre = result;
                    i=0;
                }
                if(pm==4 && i!=0){
                    result=pre/num;
                    num=0;
                    number=1;
                    push.setText("0");
                    memory.setText(Integer.toString(result));
                    pre = result;
                    i=0;
                }
                if(pm==5 && i!=0){
                    result=pre%num;
                    num=0;
                    number=1;
                    push.setText("0");
                    memory.setText(Integer.toString(result));
                    pre = result;
                    i=0;
                }


            }
        });
    }
}