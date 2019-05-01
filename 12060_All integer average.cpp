#include<iostream>
#include<algorithm>
using namespace std;

int digits(int num) {
    int contador=1;
 
    while(num/10>0)
    {
        num=num/10;
        contador++;
    }

    return contador;
}

int main() {

    int aux,i,divisor,sum,cociente,resto,da,db,diff;
    float avg;

    int cases = 1;
    int sign = 1;

    while(scanf("%d",&divisor) && divisor != 0) {
       
        cout<<"Case " << cases << ":\n";
        cases++;
        sum = 0;

        i = divisor;

        while(i>0) {
            cin>>aux;
            sum+=aux;
            i--;
        }
    
        if(sum < 0) {
            sign = -1;
            sum*=-1;
        }
        else {
            sign = 1;
        }

        int mcd = __gcd(sum,divisor);
        
        
        sum/=mcd;
        divisor/=mcd;

        avg = (float)sum/(float)divisor;

   
        cociente = sum/divisor;
        resto = sum % divisor;

        if (sum % divisor == 0.0) {

            if (sign<0) {
                cout<<"- "<<sum/divisor<<"\n";
            }
            else {
                cout<<sum/divisor<<"\n";
            }
            
        }
        else if(abs(avg) > 1) {

            da = digits(resto);
            db = digits(divisor);

            int diff = digits(cociente);

            if (sign<0) {
                diff+=2;
            }
            for (int i = 0; i<diff + db-da; i++) {
                cout<<" ";
            }
            
            cout<<resto<<"\n";

            if (sign < 0) {
                cout<<"- ";
            }
            cout<<cociente;
            

            for (int i = 0; i<db; i++) {
                cout<<"-";
            }
            cout<<"\n";
                
            for (int i = 0; i<diff; i++) {
                cout<<" ";
            }
            
            cout<<divisor<<"\n";
        }

        else if(abs(avg) < 1) {
          
            diff = 0;

            if (sign < 0) {
                diff+=2;
            }

            da = digits(sum);
            db = digits(divisor);

            for (int i = 0; i<db-da + diff; i++) {
                cout<<" ";
            }
            cout<<sum<<"\n";
                
            if (sign < 0) {
                cout<<"- ";
            }

            for (int i = 0; i<db; i++) {
                cout<<"-";
            }
            cout<<"\n";
                
            for (int i = 0; i<diff; i++) {
                cout<<" ";
            }
            cout<<divisor<<"\n";

        }
    }
}