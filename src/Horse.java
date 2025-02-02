public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
//        check=true;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
            return false;
        }

        if (chessBoard.board[toLine][toColumn] != null &&
                chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return false;
        }

        int[][] xod = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1},
                {2, -1}, {1, -2}, {-2, -1}, {-1, -2}};
        for (int i = 0; i < xod.length; i++) {
            int nextLine = line + xod[i][0];
            int nextColumn = column + xod[i][1];
            if (nextLine == toLine && nextColumn == toColumn) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
