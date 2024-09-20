class Job:
    def __init__(self, job_id, profit, deadline):
        self.job_id = job_id
        self.profit = profit
        self.deadline = deadline

def job_sequencing(jobs):
    # Sort jobs by profit in descending order
    jobs.sort(key=lambda x: x.profit, reverse=True)
    
    n = len(jobs)
    result = [False] * n  # To keep track of free time slots
    job_sequence = [None] * n  # To store the result (sequence of jobs)
    
    # Iterate through all given jobs
    for i in range(n):
        # Find a free slot for this job (note: slots are checked from the last possible slot)
        for j in range(min(n, jobs[i].deadline) - 1, -1, -1):
            # If the slot is free, assign the job to this slot
            if not result[j]:
                result[j] = True
                job_sequence[j] = jobs[i].job_id
                break
    
    # Filter out None values from job_sequence
    job_sequence = [job for job in job_sequence if job is not None]
    
    return job_sequence

# Example usage:
jobs = []

num_jobs = int(input("Enter the number of jobs: "))
    
    # Get details for each job from the user
for i in range(num_jobs):
        job_id = input(f"\nEnter job ID for {i+1} job: ")
        profit = int(input(f"Enter profit for {job_id}: "))
        deadline = int(input(f"Enter deadline for {job_id}: "))
        jobs.append(Job(job_id, profit, deadline))

job_sequence = job_sequencing(jobs)
print("\nOptimal Job Sequence:", job_sequence)
