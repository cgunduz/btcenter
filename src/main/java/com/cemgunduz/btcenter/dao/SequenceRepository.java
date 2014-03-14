package com.cemgunduz.btcenter.dao;

import com.cemgunduz.btcenter.dao.constants.Sequence;

/**
 * Created by cgunduz on 3/14/14.
 */
public interface SequenceRepository {

    public long nextSequence(Sequence sequence);
}
