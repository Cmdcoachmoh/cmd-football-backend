// routes/reports.js
import express from 'express';
import { sendReportEmail } from '../../services/sendgrid.js';
import fs from 'fs';
import path from 'path';

const router = express.Router();

router.post('/email', async (req, res) => {
  const { recipients, playerIds } = req.body;

  const attachments = playerIds.map(id => {
    const filePath = path.join(process.cwd(), 'docs', `player_${id}_report.pdf`);
    if (!fs.existsSync(filePath)) return null;
    const content = fs.readFileSync(filePath).toString('base64');
    return {
      content,
      filename: `player_${id}_report.pdf`,
      type: 'application/pdf',
      disposition: 'attachment',
    };
  }).filter(Boolean);

  try {
    await sendReportEmail({
      to: recipients,
      subject: 'Rapports CMD Football',
      text: 'Rapports de joueurs en pièce jointe.',
      html: '<p>Rapports de joueurs en pièce jointe.</p>',
      attachments,
    });
    res.json({ ok: true });
  } catch (err) {
    console.error('Email error:', err);
    res.status(500).json({ error: 'Échec de l’envoi' });
  }
});

export default router;
