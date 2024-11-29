# Function to calculate the Greatest Common Divisor (GCD) using the Euclidean Algorithm
def euclidean_algorithm(a, b):
    while b:  # Continue until b becomes 0
        a, b = b, a % b  # Update a to b and b to the remainder of a divided by b
    return a  # When b is 0, a is the GCD

# Function to calculate the GCD and coefficients for Bézout's identity using the Extended Euclidean Algorithm
def extended_euclidean_algorithm(a, b):
    if b == 0:  # Base case: if b is 0
        return a, 1, 0  # Return gcd as a, with coefficients 1 and 0

    # Recursive call, where a becomes b and b becomes a % b
    gcd, x1, y1 = extended_euclidean_algorithm(b, a % b)
    
    # Update x and y based on previous values (x1, y1)
    x = y1
    y = x1 - (a // b) * y1
    return gcd, x, y  # Return gcd along with updated x and y

if __name__ == "__main__":
    a = 56
    b = 98
    
    # Calculate GCD using the Euclidean Algorithm
    print(f"Euclidean Algorithm GCD: {euclidean_algorithm(a, b)}")
    
    # Calculate GCD and coefficients using the Extended Euclidean Algorithm
    gcd, x, y = extended_euclidean_algorithm(a, b)
    print(f"Extended Euclidean Algorithm GCD: {gcd}, x: {x}, y: {y}")
