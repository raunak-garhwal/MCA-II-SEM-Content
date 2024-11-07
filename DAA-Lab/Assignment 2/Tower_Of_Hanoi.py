def tower_of_hanoi(n, source, intermediate, destination):
    if n == 1:
        print(f"Move disk 1 from {source} to {destination}")
        return
    
    # Step 1: Move n-1 disks from source to intermediate, using destination as a helper
    tower_of_hanoi(n-1, source, destination, intermediate)

    # Step 2: Move the nth disk from source to destination
    print(f"Move disk {n} from {source} to {destination}")

    # Step 3: Move n-1 disks from intermediate to destination, using source as a helper
    tower_of_hanoi(n-1, intermediate, source, destination)

n = int(input("\nEnter the number of disks : "))
tower_of_hanoi(n, 'A', 'B', 'C')