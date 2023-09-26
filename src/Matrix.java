import java.util.Arrays;

public class Matrix {
    public final int rows;
    public final int columns;
    public final int[][] data;

    public Matrix(int[][] data)
    {
        if(data == null)
        {
            throw new IllegalArgumentException("Data must not be null.");
        }

        this.rows = data.length;
        this.columns = data[0].length;
        this.data = new int[rows][columns];
        System.arraycopy(data, 0, this.data, 0, data.length);
    }

    public Matrix add(Matrix m)
    {
        if(this.rows != m.rows || this.columns != m.columns)
        {
            throw new IllegalArgumentException("Matrices must be of the same size.");
        }

        int[][] sum = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum[i][j] = this.data[i][j] + m.data[i][j];
            }
        }

        return new Matrix(sum);
    }

    public int findSumOfMaxInRows()
    {
        int sum = 0;
        for(int i = 0; i < rows; i++)
        {
            sum += Arrays.stream(data[i]).max().getAsInt();
        }

        return sum;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                output.append(data[i][j]);
                if(j != columns - 1)
                {
                    output.append(", ");
                }
            }
            output.append("\n");
        }

        return output.toString();
    }
}
