package com.jlab.JLabSamleForSpring.common;

import org.springframework.data.relational.core.dialect.LimitClause;
import org.springframework.data.relational.core.dialect.SqlServerDialect;

public class SQLiteDialect extends SqlServerDialect {

    public static final SQLiteDialect INSTANCE = new SQLiteDialect();

    @Override
    public LimitClause limit() {
        return new LimitClause() {
            @Override
            public String getLimit(long limit) {
                return String.format("LIMIT %d", limit);
            }

            @Override
            public String getOffset(long offset) {
                return String.format("OFFSET %d", offset);
            }


			@Override
			public String getLimitOffset(long limit, long offset) {
				return String.format("LIMIT %d OFFSET %d", limit, offset);
			}

			@Override
			public Position getClausePosition() {
				return Position.AFTER_ORDER_BY;
			}
        };
    }

    public SQLiteDialect() {
        super();
    }
}