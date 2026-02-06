# Input the number of Pokémon
N = int(input("Enter the number of Pokémon: "))

# Cost of Normal Pokeball and Master Pokeball
X = int(input("Enter the cost of a Normal Pokeball: "))
Y = int(input("Enter the cost of a Master Pokeball: "))

# List to store difficulty of each Pokémon
difficulty = [0] * N

# Input the difficulty for each Pokémon
for i in range(N):
    difficulty[i] = int(input(f"Enter difficulty of Pokémon {i + 1}: "))

# Calculate the total minimum cost
total_cost = 0
for i in range(N):
    normal_cost = difficulty[i] * X
    master_cost = Y
    total_cost += min(normal_cost, master_cost)

print(f"The minimum total cost to catch all Pokémon is: {total_cost}")
