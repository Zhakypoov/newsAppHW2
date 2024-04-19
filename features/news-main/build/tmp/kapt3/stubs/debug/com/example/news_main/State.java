package com.example.news_main;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/example/news_main/State;", "", "()V", "Error", "Loading", "None", "Success", "Lcom/example/news_main/State$Error;", "Lcom/example/news_main/State$Loading;", "Lcom/example/news_main/State$None;", "Lcom/example/news_main/State$Success;", "news-main_debug"})
public abstract class State {
    
    private State() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/news_main/State$Error;", "Lcom/example/news_main/State;", "articles", "", "Lcom/example/news_main/Article;", "(Ljava/util/List;)V", "getArticles", "()Ljava/util/List;", "news-main_debug"})
    public static final class Error extends com.example.news_main.State {
        @org.jetbrains.annotations.Nullable()
        private final java.util.List<com.example.news_main.Article> articles = null;
        
        public Error(@org.jetbrains.annotations.Nullable()
        java.util.List<com.example.news_main.Article> articles) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.util.List<com.example.news_main.Article> getArticles() {
            return null;
        }
        
        public Error() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/news_main/State$Loading;", "Lcom/example/news_main/State;", "articles", "", "Lcom/example/news_main/Article;", "(Ljava/util/List;)V", "getArticles", "()Ljava/util/List;", "news-main_debug"})
    public static final class Loading extends com.example.news_main.State {
        @org.jetbrains.annotations.Nullable()
        private final java.util.List<com.example.news_main.Article> articles = null;
        
        public Loading(@org.jetbrains.annotations.Nullable()
        java.util.List<com.example.news_main.Article> articles) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.util.List<com.example.news_main.Article> getArticles() {
            return null;
        }
        
        public Loading() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/news_main/State$None;", "Lcom/example/news_main/State;", "()V", "news-main_debug"})
    public static final class None extends com.example.news_main.State {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.news_main.State.None INSTANCE = null;
        
        private None() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/news_main/State$Success;", "Lcom/example/news_main/State;", "articles", "", "Lcom/example/news_main/Article;", "(Ljava/util/List;)V", "getArticles", "()Ljava/util/List;", "news-main_debug"})
    public static final class Success extends com.example.news_main.State {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.example.news_main.Article> articles = null;
        
        public Success(@org.jetbrains.annotations.NotNull()
        java.util.List<com.example.news_main.Article> articles) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.example.news_main.Article> getArticles() {
            return null;
        }
    }
}