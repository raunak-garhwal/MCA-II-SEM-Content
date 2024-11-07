# Define a class to represent a Job
class Job:
    def __init__(self, job_id, deadline, profit):
        self.job_id = job_id
        self.deadline = deadline
        self.profit = profit

# Function to find the maximum profit sequence of jobs
def job_scheduling(jobs):
    # Sort jobs in descending order of profit
    jobs.sort(key=lambda x: x.profit, reverse=True)

    # Find the maximum deadline to create the slots array
    max_deadline = max(job.deadline for job in jobs)

    # Create a slots array to keep track of free time slots
    slots = [None] * max_deadline
    
    # Total profit
    total_profit = 0

    # Iterate through all sorted jobs
    for job in jobs:
        # Try to place the job in the latest possible slot before its deadline
        for slot in range(min(max_deadline, job.deadline) - 1, -1, -1):
            if slots[slot] is None:  # If the slot is empty
                slots[slot] = job  # Assign the job to this slot
                total_profit += job.profit
                break

    # Extract the job sequence based on the filled slots
    job_sequence = [job.job_id for job in slots if job is not None]

    return job_sequence, total_profit

# Get user input for the jobs
jobs = []
num_jobs = int(input("\nEnter the number of jobs : "))

# Get details for each job from the user
for i in range(num_jobs):
    job_id = input(f"\nEnter job ID for job {i+1} : ")
    deadline = int(input(f"Enter deadline for {job_id} : "))
    profit = int(input(f"Enter profit for {job_id} : "))
    jobs.append(Job(job_id, deadline, profit))

# Get the job sequence and total profit
job_sequence, total_profit = job_scheduling(jobs)

# Print the result
print(f"\nMaximum profit sequence of jobs: {" --> ".join(job_sequence)}")
print(f"Total Profit: {total_profit}")