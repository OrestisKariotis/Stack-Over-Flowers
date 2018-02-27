package com.plakic;




import java.util.List;

import org.elasticsearch.common.document.DocumentField;

public class SearchResults2 {

    public final long total;
    public final long start;
    public final long count;
    public final List<DocumentField> ids;

    public SearchResults2(long total, long start, long count, List<DocumentField> tits) {
        this.total = total;
        this.start = start;
        this.count = count;
        this.ids   = tits;
    }
}