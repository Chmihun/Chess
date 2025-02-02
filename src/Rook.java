public class Rook extends ChessPiece {
    public Rook(String color) {
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
        int deltaLine = Integer.signum(toLine - line);
        int deltaColumn = Integer.signum(toColumn - column);
        int currentLine = line + deltaLine;
        int currentColumn = column + deltaColumn;
        if (line != toLine&&column != toColumn) {
            return false;
        }
        //Checking for horizontal movement
        if (line == toLine) {
            while (currentColumn != toColumn) {
                if (chessBoard.board[line][currentColumn] != null) {
                    return false;
                }
                currentColumn += deltaColumn;
            }
        }
        // Check for vertical movement
        else if (column == toColumn) {
            while (currentLine != toLine) {
                if (chessBoard.board[currentLine][column] != null) {
                    return false;
                }
                currentLine += deltaLine;
            }
        }
        return true; //   ok
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
