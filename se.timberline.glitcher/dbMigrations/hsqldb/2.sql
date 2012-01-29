CREATE TRIGGER trigger_glitcher_updated_at AFTER UPDATE ON glitcher
	REFERENCING NEW AS newrow FOR EACH ROW
	BEGIN ATOMIC
		SET newrow.updated_at = CURRENT_TIMESTAMP;
	END;

CREATE TRIGGER trigger_glitch_updated_at AFTER UPDATE ON glitch
	REFERENCING NEW AS newrow FOR EACH ROW
	BEGIN ATOMIC
		SET newrow.updated_at = CURRENT_TIMESTAMP;
	END;