import matplotlib.pyplot as plt
import pandas as pd

# List of CSV files
csv_files = [
    "BubbleSort_performance_data.csv",
    "HeapSort_performance_data.csv",
    "InPlaceMergeSort_performance_data.csv",
    "InsertionSort_performance_data.csv",
    "IntroSort_performance_data.csv",
    "LSDRadixSort_performance_data.csv",
    "MSDRadixSort_performance_data.csv",
    "PancakeSort_performance_data.csv",
    "QuickSort_performance_data.csv",
    "SelectionSort_performance_data.csv",
    "ShellSort_performance_data.csv",
    "TimSort_performance_data.csv"
]

# Read CSVs into dictionary
algorithms = {}
all_sizes = set()

for file in csv_files:
    df = pd.read_csv(file)
    name = file.replace('_performance_data.csv', '')
    size_to_time = df.set_index('Size')['SortTime'].dropna().to_dict()
    algorithms[name] = size_to_time
    all_sizes.update(size_to_time.keys())

# Sort and filter input sizes to 100–10000
input_sizes = sorted(size for size in all_sizes if 250 <= size <= 10000)

# Prepare the plot
plt.figure(figsize=(14, 8), constrained_layout=True)
all_times = []

# Plot each algorithm line
for name, times in algorithms.items():
    y_vals = [times[size] for size in input_sizes if size in times]
    x_vals = [size for size in input_sizes if size in times]

    if len(x_vals) == 0:
        print(f"⚠️ Skipping {name}: no valid data points")
        continue

    all_times.extend(y_vals)
    plt.plot(x_vals, y_vals, label=name)

# Adjust axes based on data
if all_times:
    min_y = min(all_times) * 0.9
    max_y = max(all_times) * 1.1
    plt.yscale("log")
    plt.ylim(min_y, max_y)

plt.xlim(250, 10000)
plt.xlabel("Input Size")
plt.ylabel("Sort Time (ns)")
plt.title("Sorting Algorithm Performance (All Algorithms)")
plt.grid(True, which="both", linestyle="--", linewidth=0.5)
plt.legend(fontsize="small", loc='upper left', bbox_to_anchor=(1.02, 1))

# Show the plot
plt.tight_layout()
plt.savefig('All_Algorithm_Performance_Comparisons.png', dpi=300, bbox_inches='tight')
plt.close()
