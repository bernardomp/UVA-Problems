#include <iostream>
#include <string>
#include<vector>

using namespace std;

enum dir {NORTH,SOUTH,WEST,EAST};
typedef enum dir Direction;

void statistics(vector<int> visited,int blocks) {

    int no_visit = -1*blocks, one = 0, two = 0, three = 0, four = 0;
    
    for (auto i = visited.begin(); i<visited.end(); i++) {

        switch (*i)
        {
            case 0:
                no_visit++;
                break;
        
            case 1:
                one++;
                break;
            
            case 2:
                two++;
                break;
            
            case 3:
                three++;
                break;

            case 4:
                four++;
                break;
        }

    }
    cout.width(3);
    cout<<no_visit;
    cout.width(3);

    cout<<one;
    cout.width(3);

    cout<<two;
    cout.width(3);

    cout<<three;
    cout.width(3);

    cout<<four<<"\n";

}

int main()
{   int R;
    int C;
    char aux;

    while(scanf("%d %d",&R,&C) == 2 && (R || C)) {
        vector<vector<char>> map(R, vector<char>(C));
    
        vector<int> visited(R*C, 0);
        int blocks = 0;

        for(int i = 0; i<R;i++) {
            for(int j = 0; j<C;j++) {
                cin>>aux;
                map[i][j] = aux;

                if (aux == '1') blocks++;
            }
        }

        Direction curr = EAST;
        int r = R - 1;
        int c = 0;
        int linear_pos;
        
        do {
            linear_pos = c + r * C;

            if(curr == EAST) {
               
                //No right wall. Turn right
                if ( r+1 != R && (r+1 < R && map[r+1][c] == '0')) {
                    curr = SOUTH;
                    r++;
                    linear_pos = c + r * C;
                    visited[linear_pos]++;
                    
                } 

                //Turn left
                else if((c+1 < C && map[r][c+1] == '1') || c+1 >= C) {
                    curr = NORTH;
                }

                //Go ahead
                else if (c+1 < C && map[r][c+1] == '0') {
                    c++;
                    linear_pos = c + r * C;
                    visited[linear_pos]++;
                    
                }
            }

            else if (curr == NORTH)
            {
            
                //No right wall. Turn right
                if ( c+1 != C && (c+1 < C && map[r][c+1] == '0')) {
                    curr = EAST;
                    c++;
                    linear_pos = c + r * C;
                    visited[linear_pos]++;
                } 
                //Turn left
                else if((r-1 > -1 && map[r-1][c] == '1') || r-1 < 0) {
                    curr = WEST;
                }
                //Go ahead
                else if (r-1 > -1 && map[r-1][c] == '0') {
                    r--;
                    linear_pos = c + r * C;
                    visited[linear_pos]++;
                   
                }
            }

            else if (curr == SOUTH)
            {
                 //No right wall. Turn right
                if ( c-1 != -1 && (c-1 > -1 && map[r][c-1] == '0')) {
                    curr = WEST;
                    c--;
                    linear_pos = c + r * C;
                    visited[linear_pos]++;
                   
                
                } 
                //Turn left
                else if((r+1 < R && map[r+1][c] == '1') || r+1 >= R) {
                    curr = EAST;
                }
                //Go ahead
                else if (r+1 < R && map[r+1][c] == '0') {
                    r++;
                    linear_pos = c + r * C;
                    visited[linear_pos]++;
                    
                }
            }
            //West
            else {
                //No hay pared derecha. Gira derecha
                if ( r-1 != -1 && (r-1 > -1 && map[r-1][c] == '0')) {
                    curr = NORTH;
                    r--;
                    linear_pos = c + r * C;
                    visited[linear_pos]++;
                  
                } 
                //Turn left
                else if((c-1 > -1 && map[r][c-1] == '1') || c-1 <= -1) {
                    curr = SOUTH;
                }
                //Go ahead
                else if (c-1 > -1 && map[r][c-1] == '0') {
                    c--;
                    linear_pos = c + r * C;
                    visited[linear_pos]++;
                }

            }
    
        } while(!(r == R-1 && c == 0));

        statistics(visited,blocks);
       
    }
}
