import BFS;
import DFS;


def main():
    
    print("\nGraph Representation:")
    
    while(True):

        print("Choose a option :- ")
        print("[1]. Perform BFS ")
        print("[2]. Perform DFS")
        print("[3]. Exit ")
        
        choice = input("\nEnter option :- ")
        
        if choice == 1:
                
            BFS.bfs(visited,graph,n)
            
        elif choice == 2:
            
            DFS.dfs(visited,graph,n)
                
        elif choice == 3:
            
            break   
                
        else:
            
            print("Invalid choice. Please enter correct option")


main()
        
