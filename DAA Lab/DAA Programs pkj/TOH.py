def tower_of_hanoi(n, source, auxiliary, target):
    if n == 1:
        print(f"Move disk 1 from {source} to {target}")
        return
    tower_of_hanoi(n - 1, source, target, auxiliary)
    print(f"Move disk {n} from {source} to {target}")
    tower_of_hanoi(n - 1, auxiliary, source, target)


while True :
    num_disks = int(input("\nEnter Number of disk : "))
    tower_of_hanoi(num_disks, 'S', 'A', 'T')
    


