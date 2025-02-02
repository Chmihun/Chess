public class King extends ChessPiece {
    public King(String color) {
        super(color);
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

        int[][] xod = {{-1, -1}, {-1, 0},
                {-1, 1}, {0, 1},
                {1, 1}, {1, 0},
                {1, -1}, {0, -1}};
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
    public String getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int i = 0; i < board.board.length; i++) {
            for (int j = 0; j < board.board[i].length; j++) {
                if (board.board[i][j] != null && !board.board[i][j].getColor().equals(this.color)) {
                    if (board.board[i][j].canMoveToPosition(board, i, j, line, column) ||
                            (board.board[1][3] != null && board.board[1][3].getSymbol().equals("P") &&
                                    !board.board[1][3].getColor().equals(this.getColor())) ||
                            (board.board[1][5] != null && board.board[1][5].getSymbol().equals("P") &&
                                    !board.board[1][5].getColor().equals(this.getColor())) ||

                            (board.board[6][3] != null && board.board[6][3].getSymbol().equals("P") &&
                                    !board.board[6][3].getColor().equals(this.getColor())) ||
                            (board.board[6][5] != null && board.board[6][5].getSymbol().equals("P") &&
                                    !board.board[6][5].getColor().equals(this.getColor()))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
