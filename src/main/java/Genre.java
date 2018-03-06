public enum Genre {
    THRILLER("a genre that revolves around anticipation and suspense"),

    ROMCOM("a genre with light-hearted, humorous plotlines, centered on romantic ideals"),

    ADVENTURE("a genre in which the protagonist or protagonists end up in a series of challenges that typically include violence, extended fighting, physical feats, and frantic chases"),

    CRIME("a genre that fictionalises crimes, their detection, criminals, and their motives"),

    CHILDRENS("material written and produced for the information or entertainment of children and young adults");

        private String description;

        Genre(String description) {
        this.description = description;
    }

        public String getDescription(){
            return description;
        }

}
