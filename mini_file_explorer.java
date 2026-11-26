package dsa_project;

import java.util.*;

class FolderNode {
    String name;
    boolean isFile;
    ArrayList<FolderNode> Children = new ArrayList<>();

    FolderNode(String name, boolean isFile) {
        this.name = name;
        isFile = false;
    }

    void addChild(FolderNode child) {
        Children.add(child);
    }
}

/**
 * mini_file_explorer
 */
public class mini_file_explorer {

    static int depth(FolderNode root) {
        if (root == null) {
            return 0;
        }

        return (root.Children.size());
    }

    public static void main(String[] args) {
        FolderNode file = new FolderNode("file", false);
        FolderNode docs = new FolderNode("docs", false);
        FolderNode pics = new FolderNode("pics", false);

        file.addChild(docs);
        file.addChild(pics);

        System.out.println(file.Children.size());

        FolderNode cvPdf = new FolderNode("cv.pdf", true);
        FolderNode img = new FolderNode("img.png", true);

        docs.addChild(cvPdf);
        pics.addChild(img);
        System.out.println(docs.Children.size() + " " + pics.Children.size());
        System.out.println(cvPdf.Children.size());

        System.out.println(depth(img));
    }
}