public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    ChessBoard board = new ChessBoard("White");

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine > 7 || line == toLine) {
            return false;
        }
//        // Logic for white pawns
        if (color.equals("White")) {
//            // Move one square forward
            if (column == toColumn) {
                if (line == 1) {
                    if (((toLine == line + 1) && chessBoard.board[toLine][toColumn] == null ||
                            toLine == line + 2) &&
                            chessBoard.board[toLine][toColumn] == null &&
                            chessBoard.board[line + 1][toColumn] == null) {
                        return true;
                    }

                } else if ((toLine == line + 1) && chessBoard.board[toLine][toColumn] == null && (toLine != 7)) {
                    return true;

                } else if ((toLine == line + 1) && (toLine == 7) &&
                        chessBoard.board[toLine][toColumn] == null) {
                    chessBoard.board[line][column] = new Queen(getColor());
                    chessBoard.board[toLine][toColumn] = new Queen(getColor());
                    return true;
                }
            }
            // Killing an enemy piece

            else if ((toLine - line == 1) && Math.abs(column - toColumn) == 1 && chessBoard.board[toLine][toColumn] != null &&
                    (toLine != 7) && chessBoard.board[toLine][toColumn].getColor().equals("Black")) {
                return true;
            } else if ((toLine - line == 1) && Math.abs(column - toColumn) == 1 && chessBoard.board[toLine][toColumn] != null &&
                    (toLine == 7 && chessBoard.board[toLine][toColumn].getColor().equals("Black"))) {
                chessBoard.board[line][column] = new Queen(getColor());
                chessBoard.board[toLine][toColumn] = new Queen(getColor());
                return true;

            }
        }
//        // Logic for Black pawns
        if (color.equals("Black")) {
//
            if (column == toColumn) { // Move one square forward
                if (line == 6) {
                    if (((toLine == line - 1) && chessBoard.board[toLine][toColumn] == null ||
                            toLine == line - 2) &&
                            chessBoard.board[toLine][toColumn] == null &&
                            chessBoard.board[line - 1][toColumn] == null) {
                        return true;
                    }

                } else if ((toLine == line - 1) && chessBoard.board[toLine][toColumn] == null && (toLine != 0)) {
                    return true;

                } else if ((toLine == line - 1) && (toLine == 0) &&
                        chessBoard.board[toLine][toColumn] == null) {
                    chessBoard.board[line][column] = new Queen(getColor());
                    chessBoard.board[toLine][toColumn] = new Queen(getColor());
                    return true;
                }
            }
            // Killing an enemy piece
            if (column != toColumn) {
                if ((Math.abs(toLine - line) == 1) && Math.abs(column - toColumn) == 1 && chessBoard.board[toLine][toColumn] != null &&
                        (toLine != 0) && !chessBoard.board[toLine][toColumn].getColor().equals("Black")) {
                    return true;
                } else if ((Math.abs(toLine - line) == 1) && Math.abs(column - toColumn) == 1 &&
                        chessBoard.board[toLine][toColumn] != null &&
                        (toLine == 0) && !chessBoard.board[toLine][toColumn].getColor().equals("Black")) {
                    chessBoard.board[line][column] = new Queen(getColor());
                    chessBoard.board[toLine][toColumn] = new Queen(getColor());
                    return true;
                }
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
        return "P";
    }
}
